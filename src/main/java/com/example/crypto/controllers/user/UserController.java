package com.example.crypto.controllers.user;

import com.example.crypto.config.SwaggerConfig;
import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.mappers.user.UserMapper;
import com.example.crypto.models.user.UserRequest;
import com.example.crypto.models.user.UserResponse;
import com.example.crypto.sevices.user.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/admin/v1/user")
@RestController
@Api(tags = {SwaggerConfig.USER_TAG})
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    /**
     * Returns created user.
     *
     * @param userRequest specifies a data for creating a user
     * @return created user
     */
    @PostMapping(path = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        return userMapper.toResponse(
            userService.createUser(
                userMapper.fromRequest(userRequest)
            )
        );
    }

    @PostMapping(path = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse loginUser(@RequestBody UserRequest userRequest) throws UserNotFoundException {
        return userMapper.toResponse(
            userService.loginUser(
                userMapper.fromRequest(userRequest)
            )
        );
    }

    /**
     * Returns a user for requested an identifier of a user
     *
     * @param userId specifies an identifier of a user
     * @return a user for requested an identifier of user
     * @throws UserNotFoundException when user not found
     */
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUserById(@PathVariable long userId) throws UserNotFoundException {
        return userMapper.toResponse(
            userService.getUserById(userId)
        );
    }

    /**
     * Returns a list of all users
     *
     * @return a list of all users
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getUsers() {
        return userService.getUsers()
            .stream()
            .map(userMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * Returns updated user
     *
     * @param userId specifies an identifier of a user
     * @param userRequest specifies a data for updating user
     * @return updated user
     * @throws UserNotFoundException when user not found
     */
    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@PathVariable long userId, @RequestBody UserRequest userRequest) throws UserNotFoundException {
        return userMapper.toResponse(
            userService.updateUser(
                userMapper.fromRequest(userRequest, userId)
            )
        );
    }

    /**
     * Removes a user for requested an identifier of a user
     *
     * @param userId specifies an identifier of a user
     */
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}
