package com.telran.addressbook;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Contact {
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;

}
