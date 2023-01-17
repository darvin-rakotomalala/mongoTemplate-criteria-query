package com.poc.controller;

import com.poc.constraint.validation.UserValidator;
import com.poc.model.dto.UserProfileDTO;
import com.poc.service.application.UserProfileCUDSA;
import com.poc.service.application.UserProfileRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserProfileController {

    private final UserProfileCUDSA userCUDSA;
    private final UserProfileRSA userRSA;
    private final UserValidator userValidator;

    @InitBinder("userProfileDTO")
    protected void initUserProfileDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(userValidator);
    }

    @Operation(summary = "WS used to create a user")
    @PostMapping
    public UserProfileDTO createUser(@RequestBody @Validated UserProfileDTO userDto) {
        return userCUDSA.saveUser(userDto);
    }

    @Operation(summary = "WS used to save all users")
    @PostMapping("/saveAll")
    public List<UserProfileDTO> saveAllUsers(@RequestBody List<UserProfileDTO> userProfiles) {
        return userCUDSA.saveAllUsers(userProfiles);
    }

    @Operation(summary = "WS used to update user")
    @PutMapping
    public UserProfileDTO updateUser(@RequestBody @Validated UserProfileDTO userProfile) {
        return userCUDSA.updateUser(userProfile);
    }

    @Operation(summary = "WS used to get user by id")
    @GetMapping("/{id}")
    public UserProfileDTO getUserById(@PathVariable("id") UUID id) {
        return userRSA.getUserById(id);
    }

    @Operation(summary = "WS used to get all users")
    @GetMapping
    public HelpPage<UserProfileDTO> getAllUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        return userRSA.getAllUsers(page, size);
    }

    @Operation(summary = "WS used to get all users by name")
    @GetMapping("/byName")
    public HelpPage<UserProfileDTO> getUsersByName(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        return userRSA.getUsersByName(name, page, size);
    }

    @Operation(summary = "WS used to delete user by id")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") UUID id) {
        userCUDSA.deleteUserById(id);
        return "User with this id " + id + " deleted successfully !";
    }

    @Operation(summary = "WS used to get if name user already exist")
    @GetMapping("/existByName")
    public boolean existByName(@RequestParam(name = "name", required = true) String name) {
        return userRSA.existByName(name);
    }

    @Operation(summary = "WS used to search users by attributes")
    @GetMapping("/search")
    public HelpPage<UserProfileDTO> searchUserProfile(
            @RequestParam(name = "input", required = true) List<String> input,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return userRSA.searchUserProfile(input, pageable);
    }

}
