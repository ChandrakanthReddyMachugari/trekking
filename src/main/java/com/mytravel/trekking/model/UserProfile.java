package com.mytravel.trekking.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    @NotBlank(message = "can't be blank")
    private String username;
    @NotNull
    @Column(length = 35,nullable = false)
    private String firstName;
    @Column(length = 35,nullable = false)
    @NotNull
    private String lastName;

//    @OneToMany
//    @JoinColumn(name = "address_id")
//    private List<Address> address;

    @Column(length = 50,nullable = false)
    @Email
    private String emailId;
    @Column(length = 15,nullable = false)
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;


}
