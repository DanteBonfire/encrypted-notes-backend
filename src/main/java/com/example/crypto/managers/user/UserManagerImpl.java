package com.example.crypto.managers.user;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.mappers.user.UserEntityMapper;
import com.example.crypto.models.user.User;
import com.example.crypto.repositories.user.UserRepository;
import com.example.crypto.utils.StreamTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager{
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public User save(User user) {
        return userEntityMapper.fromEntity(
            userRepository.save(
                userEntityMapper.toEntity(user)
            )
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsers() {
        return StreamTools.toStream(userRepository.findAll())
            .map(userEntityMapper::fromEntity)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(long userId) throws UserNotFoundException {
        return userEntityMapper.fromEntity(
            userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(MessageFormat.format("Cannot find user with id {0}", userId)))
        );
    }

    @Override
    public User getUserByNameAndPassword(User user) throws UserNotFoundException {
        return userEntityMapper.fromEntity(
            userRepository.findByNameAndPassword(user.getName(), user.getPassword())
                .orElseThrow(() -> new UserNotFoundException(MessageFormat.format("Cannot find user with name {0} or invalid password", user.getName())))
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
