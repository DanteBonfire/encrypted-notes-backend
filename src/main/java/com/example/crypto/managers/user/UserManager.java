package com.example.crypto.managers.user;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.models.user.User;

import java.util.List;

public interface UserManager {
    /**
     * Returns updated user.
     *
     * @param user specifies a user
     * @return updated user
     */
    User save(User user);

    /**
     * Returns all users
     *
     * @return all users
     */
    List<User> getUsers();

    /**
     * Returns a user for requested an identifier of a user
     *
     * @param userId specifies an identifier of a user
     * @return a user for requested an identifier of user
     * @throws UserNotFoundException when user not found
     */
    User getUser(long userId) throws UserNotFoundException;

    User getUserByNameAndPassword(User user) throws UserNotFoundException;

    /**
     * Removes a user for requested an identifier of a user
     *
     * @param userId specifies an identifier of a user
     */
    void deleteUser(long userId);
}
