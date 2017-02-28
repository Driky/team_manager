package com.gmail.driktheviking.modules.user.mapper;

import com.gmail.driktheviking.modules.user.db.entities.UserEntity;
import com.gmail.driktheviking.modules.user.representations.UserRepresentation;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class UserMapper {

    public UserRepresentation map(UserEntity userEntity) {
        return (userEntity == null) ? null : new UserRepresentation(
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmailAddress()
        );
    }

    public List<UserRepresentation> map(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::map).collect(Collectors.toList());
    }
}