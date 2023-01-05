package com.example.crypto.sevices.user;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.models.user.User;

import java.util.List;

public interface UserService {
    /**
     * Returns created user.
     *
     * @param user specifies a user
     * @return created user
     */
    User createUser(User user);

    /**
     * Returns login user.
     *
     * @param user specifies a user
     * @return login user
     * @throws UserNotFoundException
     */
    User loginUser(User user) throws UserNotFoundException;

    /**
     * Returns all users
     *
     * @return all users
     */
    List<User> getUsers();

    /**
     * Returns a user for requested identifier of a user
     *
     * @param userId specifies an identifier of a user
     * @return a user for requested identifier of a user
     * @throws UserNotFoundException when user not found
     */
    User getUserById(long userId) throws UserNotFoundException;

    /**
     * Returns updated user
     *
     * @param user specifies a user
     * @return updated user
     * @throws UserNotFoundException when user not found
     */
    User updateUser(User user) throws UserNotFoundException;

    /**
     * Removes a user for requested identifier of a user
     *
     * @param userId specifies an identifier of a user
     */
    void deleteUser(long userId);
}
