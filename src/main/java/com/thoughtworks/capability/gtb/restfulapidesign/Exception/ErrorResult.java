package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private Integer code;
    private String message;
}
