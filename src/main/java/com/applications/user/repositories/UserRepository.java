package com.applications.user.repositories;

import com.applications.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    List<UserModel> findAllByActive(boolean isActive);

    List<UserModel> findAllByAge(int age);

    UserModel findUserByEmail(String email);
}
