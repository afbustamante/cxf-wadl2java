package net.andresbustamante.example.users.services.impl;

import net.andresbustamante.example.users.beans.User;
import net.andresbustamante.example.users.services.UsersManagementService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

import static net.andresbustamante.example.common.util.DateUtils.getCurrentDateTime;

@Service
public class UsersManagementServiceImpl implements UsersManagementService {

    private final Map<Integer, User> usersMap = new TreeMap<>();

    public UsersManagementServiceImpl() {
        usersMap.put(1, new User(1, "Roger", "Federer", "roger.federer@email.com"));
        usersMap.put(2, new User(2, "Rafael", "Nadal", "rafael.nadal@email.com"));
        usersMap.put(3, new User(3, "Novak", "Djokovic", "novak.djokovic@email.com"));
    }

    @Override
    public int createUser(User user) {
        Integer id = usersMap.size() + 1;
        user.setId(id);
        user.setCreationDate(getCurrentDateTime());
        usersMap.put(id, user);
        return id;
    }

    @Override
    public User findUserById(Integer id) {
        return usersMap.get(id);
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteUser(Integer id) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
