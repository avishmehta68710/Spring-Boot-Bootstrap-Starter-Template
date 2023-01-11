package com.applications.user.controllers;

import com.applications.user.dto.response.ResponseDTO;
import com.applications.user.dto.response.ResponseMessageDTO;
import com.applications.user.enums.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.HealthAPI.BASE_URL)
@Slf4j
public class HealthController {
    @GetMapping(Endpoints.HealthAPI.HEALTH)
    public ResponseDTO getHealth(){
        log.info("{} api called",Endpoints.HealthAPI.HEALTH);
        return new ResponseDTO(new ResponseMessageDTO("{\"message\" : \"Application Version 1.0\"}"),null, StatusCodeEnum.SUCCESS, HttpStatus.OK);
    }
}
