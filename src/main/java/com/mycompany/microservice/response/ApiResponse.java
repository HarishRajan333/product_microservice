package com.mycompany.microservice.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private int statusCode;
    private Object value;
    private Map<String, String> errors;

}
