package com.poc.model.domain;

import com.poc.model.constant.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userProfile")
public class UserProfile {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String mobile;
    private String emailId;
    private String profession;
    private String pinCode;
    private List<String> roles = new ArrayList<>();
    private Instant createDate;
    private Instant updateDate;
}
