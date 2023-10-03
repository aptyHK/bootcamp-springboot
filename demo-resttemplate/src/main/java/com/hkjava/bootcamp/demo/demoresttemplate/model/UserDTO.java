package com.hkjava.bootcamp.demo.demoresttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// point 1: how many annotation needed?
// point 2: need static?

// 1, after try and error by remove different annotation, would know only @getter is the must require annotation
// no need to keep annotation that is necessary, like only put @builder when you think you need it
// *necessary annotation - i) @Getter ii) NoArgumentConstructor (if added other argument related constructor like @builder etc, then must need to @NoArgumentConstructor)
// 2, no matter static class or not, the program can handle
// but if no special needs, should keep static, so no need to waste memory to let the program create object
// if it is static, can create address by only User.address
// but if not static, need to new User() first then to create address, which 1 extra object created every time

// The outer class need to be instance class
// for the inner class, when it need to be instance?
// e.g address need to be share to other class e.g. student, then cannot set as static

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserDTO {
    private long id;
    private String name;
    @JsonProperty("x")
    private String username;

}

// public class User {
//     private String id; // can set everything as string here, do defend on controller / when process with actual method
//     private String name;
//     private String username;
//     private String email;
//     private String phone;
//     private String website;
//     private Address address;

//     public class Address {
//         private String street;
//         private String suite;
//         private String city;
//         private String zipcode;
//         private Geo geo;

//         public class Geo {
//             private String lat;
//             private String lng;

//         }

//         public class company {
//             private String name;
//             private String catchPhrase;
//             private String bs;

//         }
//     }
// }
