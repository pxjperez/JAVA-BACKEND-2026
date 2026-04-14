package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorEntity {
     private Integer code;   
    private String status;
    private String message;
}
