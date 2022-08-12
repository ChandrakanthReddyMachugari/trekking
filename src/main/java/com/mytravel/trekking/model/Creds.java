package com.mytravel.trekking.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Creds {

    @NotNull
    private String username;
    private String password;

}
