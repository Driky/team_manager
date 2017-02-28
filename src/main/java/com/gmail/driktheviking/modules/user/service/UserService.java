package com.gmail.driktheviking.modules.user.service;

import com.google.common.hash.Hashing;
import com.gmail.driktheviking.modules.user.db.repositories.UserRepository;
import com.gmail.driktheviking.modules.user.mapper.UserMapper;
import com.gmail.driktheviking.modules.user.representations.UserRepresentation;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    /**
     * Checks whether the given credentials are valid.
     */
    public boolean checkCredentials(String username, String password) {
        return userRepository.findByUsernameAndPasswordHash(username, getSha256Hash(password)) != null;
    }

    /**
     * Returns all users.
     */
    public List<UserRepresentation> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    /**
     * Returns a user by username.
     *
     * Returns NULL in case the user does not exist.
     *
     * @param username
     *            Username of the user to return
     */
    public UserRepresentation getUserByUsername(String username) {
        return userMapper.map(userRepository.findByUsername(username));
    }

    /**
     * Returns all users with the given hair color.
     *
     * @param hairColor
     *            The hair color
     */
    /*public List<UserRepresentation> getUsersByHairColor(HairColor hairColor) {
        return userMapper.map(userRepository.findByHairColor(hairColor));
    }*/

    private static String getSha256Hash(String clearTypePassword) {
        return Hashing.sha256().hashBytes(clearTypePassword.getBytes()).toString();
    }
}