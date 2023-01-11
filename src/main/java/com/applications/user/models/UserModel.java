package com.applications.user.models;

import com.applications.user.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "users",schema = "public")
public class UserModel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String phoneNo;
    private String gender;
    private int age;
    private boolean active;
    private Date createdAt;
    private Date updatedAt;
}
