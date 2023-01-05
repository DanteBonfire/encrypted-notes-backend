package com.example.crypto.sevices.user;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.managers.notePreview.NotePreviewManager;
import com.example.crypto.managers.user.UserManager;
import com.example.crypto.models.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserManager userManager;
//    private final NotePreviewManager notePreviewManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public User createUser(User user) {
        return userManager.save(user);
    }

    @Override
    public User loginUser(User user) throws UserNotFoundException {
        return userManager.getUserByNameAndPassword(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsers() {
        return userManager.getUsers();
    }

    @Override
    public User getUserById(long userId) throws UserNotFoundException {
        return userManager.getUser(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateUser(User user) throws UserNotFoundException {
        return userManager.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(long userId) {
        userManager.deleteUser(userId);
    }
}
