package net.andresbustamante.example.users.mappers;

import net.andresbustamante.example.users.UserType;
import net.andresbustamante.example.users.beans.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserType userType);

    UserType map(User user);
}
