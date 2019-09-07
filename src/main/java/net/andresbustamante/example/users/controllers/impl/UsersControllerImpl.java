package net.andresbustamante.example.users.controllers.impl;

import net.andresbustamante.example.controllers.UsersController;
import net.andresbustamante.example.users.UserType;
import net.andresbustamante.example.users.beans.User;
import net.andresbustamante.example.users.mappers.UserMapper;
import net.andresbustamante.example.users.services.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class UsersControllerImpl implements UsersController {

    @Autowired
    private UsersManagementService usersManagementService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response createUser(UserType user) {
        int id = usersManagementService.createUser(userMapper.map(user));

        try {
            String location = "/users/" + id;
            return Response.created(new URI(location)).entity(id).build();
        } catch (URISyntaxException e) {
            return Response.status(CREATED).entity(id).build();
        }
    }

    @Override
    public Response getUserById(int id) {
        User u = usersManagementService.findUserById(id);

        if (u != null) {
            return Response.ok(userMapper.map(u)).build();
        } else {
            return Response.status(NOT_FOUND).build();
        }
    }

    @Override
    public Response updateUserById(int id, UserType user) {
        User u = usersManagementService.findUserById(id);

        if (u != null) {
            usersManagementService.updateUser(userMapper.map(user));
            return Response.accepted().build();
        } else {
            return Response.status(NOT_FOUND).build();
        }
    }

    @Override
    public Response deleteUserById(int id) {
        User u = usersManagementService.findUserById(id);

        if (u != null) {
            usersManagementService.deleteUser(id);
            return Response.noContent().build();
        } else {
            return Response.status(NOT_FOUND).build();
        }
    }
}
