package net.andresbustamante.example.users.services;

import net.andresbustamante.example.users.beans.User;

public interface UsersManagementService {

    int createUser(User user);

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
