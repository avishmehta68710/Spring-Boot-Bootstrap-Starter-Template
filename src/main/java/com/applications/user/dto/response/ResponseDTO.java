package com.applications.user.dto.response;

import com.applications.user.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ResponseDTO {
    private HttpStatus httpStatusCode;
    private ResponseMessageDTO message;
    private Object result;
    public Integer applicationStatusCode;
    public ResponseDTO(){

    }

    public ResponseDTO(ResponseMessageDTO message, Object result, StatusCodeEnum statusCode,HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.result = result;
        this.applicationStatusCode = statusCode.statusCodeValue();
    }

    public ResponseDTO(StatusCodeEnum statusCode,ResponseMessageDTO message,HttpStatus httpStatusCode) {
        this.applicationStatusCode = statusCode.statusCodeValue();
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

}
