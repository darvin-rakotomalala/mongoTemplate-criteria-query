package com.poc.controller;

import com.poc.model.dto.UserProfileDTO;
import com.poc.service.application.FindQueryRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users/findQuery")
public class FindQueryController {

    private final FindQueryRSA findQueryRSA;

    @Operation(summary = "WS used to get user by lastName")
    @GetMapping("/byLastName")
    public List<UserProfileDTO> getUserProfileByLastName(
            @RequestParam(name = "lastName", required = true) String lastName) {
        return findQueryRSA.getUserProfileByLastName(lastName);
    }

    @Operation(summary = "WS used to get user by lastName")
    @GetMapping("/byFirstName")
    public List<UserProfileDTO> getUserProfileByFirstName(
            @RequestParam(name = "firstName", required = true) String firstName) {
        return findQueryRSA.getUserProfileByFirstName(firstName);
    }


}
