package com.applications.user.dto.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String gender;
    private int age;
    private boolean active;
}