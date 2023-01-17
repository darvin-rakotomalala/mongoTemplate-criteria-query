package com.poc.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.poc.model.constant.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserProfileDTO {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private UUID id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Gender gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobile;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String profession;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pinCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> roles = new ArrayList<>();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant createDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant updateDate;
}
