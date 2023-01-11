package com.applications.user.controllers;

import com.applications.user.dto.request.UpdateUserDTO;
import com.applications.user.dto.response.ResponseDTO;
import com.applications.user.dto.response.ResponseMessageDTO;
import com.applications.user.enums.StatusCodeEnum;
import com.applications.user.models.UserModel;
import com.applications.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoints.UserAPI.BASE_URL)
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(Endpoints.UserAPI.USER)
    public ResponseDTO getAllUsers(@RequestParam(value = "isActive",defaultValue = "true",required = false) boolean isActive){
        log.info("{}{} api called",Endpoints.UserAPI.BASE_URL,Endpoints.UserAPI.USER);
        try{
            return userService.getAllUsers(isActive);
        } catch (Exception e){
            log.error("Exception occurred :: {}",e.getMessage());
            return new ResponseDTO(new ResponseMessageDTO("Internal Exception Occurred"),null,StatusCodeEnum.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(Endpoints.UserAPI.USER_BY_EMAIL)
    public ResponseDTO getUserByEmail(@RequestParam String email){
        log.info("{}{} api called",Endpoints.UserAPI.BASE_URL,Endpoints.UserAPI.USER_BY_EMAIL);
        try{
            return userService.getUserByEmail(email);
        } catch (Exception e){
            log.error("Exception occurred :: {}",e.getMessage());
            return new ResponseDTO(StatusCodeEnum.INTERNAL_SERVER_ERROR, new ResponseMessageDTO("Internal Exception Occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(Endpoints.UserAPI.ADD_USER)
    public ResponseDTO addUser(@RequestBody UserModel newUser){
        log.info("{}{} api called",Endpoints.UserAPI.BASE_URL,Endpoints.UserAPI.ADD_USER);
        try{
            return userService.addUser(newUser);
        } catch (Exception e){
            log.error("Exception occurred :: {}",e.getMessage());
            return new ResponseDTO(StatusCodeEnum.INTERNAL_SERVER_ERROR,new ResponseMessageDTO("Internal Exception Occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(Endpoints.UserAPI.UPDATE_USER)
    public ResponseDTO updateUserByEmail(@RequestParam String email, @RequestBody UpdateUserDTO newUserDetails){
        log.info("{}{} api called",Endpoints.UserAPI.BASE_URL,Endpoints.UserAPI.UPDATE_USER);
        try{
            if (newUserDetails == null){
                log.error("Invalid request body");
                return new ResponseDTO(new ResponseMessageDTO("Invalid request body"),null,StatusCodeEnum.BAD_REQUEST,HttpStatus.BAD_REQUEST);
            }
            return userService.updateUserByEmail(email, newUserDetails);
        } catch (Exception e){
            log.error("Exception occurred :: {}",e.getMessage());
            return new ResponseDTO(StatusCodeEnum.INTERNAL_SERVER_ERROR,new ResponseMessageDTO("Internal Exception Occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(Endpoints.UserAPI.DELETE_USER_BY_EMAIL)
    public ResponseDTO deleteUserByEmail(@RequestParam String email){
        log.info("{}{} api called",Endpoints.UserAPI.BASE_URL,Endpoints.UserAPI.DELETE_USER_BY_EMAIL);
        try{
            return userService.deleteUserByEmail(email);
        } catch (Exception e){
            log.error("Exception Occurred :: {}",e.getMessage());
            return new ResponseDTO(new ResponseMessageDTO("Internal Exception Occurred"),null,StatusCodeEnum.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
