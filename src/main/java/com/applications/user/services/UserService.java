package com.applications.user.services;

import com.applications.user.dto.request.UpdateUserDTO;
import com.applications.user.dto.response.ResponseDTO;
import com.applications.user.dto.response.ResponseMessageDTO;
import com.applications.user.enums.GenderEnum;
import com.applications.user.enums.StatusCodeEnum;
import com.applications.user.models.UserModel;
import com.applications.user.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseDTO getUserByEmail(String email){
        UserModel user = userRepository.findUserByEmail(email);
        if (user == null){
            log.error("User not found");
            return new ResponseDTO(new ResponseMessageDTO("User not found"),null,StatusCodeEnum.BAD_REQUEST,HttpStatus.BAD_REQUEST);
        } else {
            log.info("User with email {} found",email);
            return new ResponseDTO(new ResponseMessageDTO("User found successfully"),user, StatusCodeEnum.SUCCESS,HttpStatus.OK);
        }
    }

    public ResponseDTO updateUserByEmail(String email, UpdateUserDTO newUserDetails){
        UserModel user = (UserModel) getUserByEmail(email).getResult();
        boolean age = newUserDetails.getClass().equals("age");
        if (newUserDetails.getFirstName() != null){
            user.setFirstName(newUserDetails.getFirstName());
        }
        if (newUserDetails.getLastName() != null){
            user.setLastName(newUserDetails.getLastName());
        }
        if (newUserDetails.getPhoneNo() != null){
            user.setPhoneNo(newUserDetails.getPhoneNo());
        }
        if (age){
            if (newUserDetails.getAge()<=0 || newUserDetails.getAge() >=100){
                log.error("Invalid age");
                System.out.println(age);
                System.out.println(newUserDetails.getAge());
                return new ResponseDTO(new ResponseMessageDTO("Invalid age"),null,StatusCodeEnum.BAD_REQUEST,HttpStatus.BAD_REQUEST);
            } else {
                user.setAge(newUserDetails.getAge());
            }
        }
        if (newUserDetails.getGender() != null){
            String gender = validateAge(newUserDetails);
            if (gender == null){
                log.error("Invalid Gender ");
                return new ResponseDTO(new ResponseMessageDTO("Invalid Gender"),null,StatusCodeEnum.BAD_REQUEST,HttpStatus.BAD_REQUEST);
            } else {
                user.setGender(GenderEnum.valueOf(newUserDetails.getGender().toUpperCase()).toString());
            }
        }
        if (!newUserDetails.isActive()){
            user.setActive(false);
        }
        user.setUpdatedAt(new Date());
        log.info("User with email {} has been updated successfully",email);
        return new ResponseDTO(new ResponseMessageDTO("Updated Successfully"),user,StatusCodeEnum.SUCCESS,HttpStatus.OK);
    }

    public String validateAge(UpdateUserDTO newUserDetails){
        for(GenderEnum genderEnum: GenderEnum.values()){
            if (genderEnum.name().equals(newUserDetails.getGender().toUpperCase())){
                return newUserDetails.getGender();
            }
        }
        return null;
    }

    public ResponseDTO getAllUsers(boolean isActive){
        List<UserModel> users = userRepository.findAllByActive(isActive);
        if (users != null){
            log.info("Users found successfully");
            return new ResponseDTO(new ResponseMessageDTO("Users fetched Successfully"),users,StatusCodeEnum.SUCCESS,HttpStatus.OK);
        } else {
            log.error("No Users found");
            return new ResponseDTO(new ResponseMessageDTO("No Users found"),null,StatusCodeEnum.BAD_REQUEST,HttpStatus.NO_CONTENT);
        }
    }

    public ResponseDTO addUser(UserModel newUser){
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        newUser.setActive(true);
        userRepository.save(newUser);
        log.info("User with email {} has been added successfully",newUser.getEmail());
        return new ResponseDTO(new ResponseMessageDTO("User added Successfully"),newUser,StatusCodeEnum.SUCCESS,HttpStatus.OK);
    }

    public ResponseDTO deleteUserByEmail(String email){
        ResponseDTO user = getUserByEmail(email);
        UserModel userToDelete = (UserModel) user.getResult();
        userToDelete.setActive(false);
        userToDelete.setUpdatedAt(new Date());
        log.info("User with email {} has been deleted successfully",email);
        return new ResponseDTO(new ResponseMessageDTO("User deleted successfully"),user, StatusCodeEnum.SUCCESS,HttpStatus.OK);
    }

}
