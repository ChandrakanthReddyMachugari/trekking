package com.mytravel.trekking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryCode {
    private String E164;
    private String phone_code;
    private String country_name;
}
