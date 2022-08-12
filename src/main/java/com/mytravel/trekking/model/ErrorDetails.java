package com.mytravel.trekking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private String errorCode;
    private String errorMessage;
}
