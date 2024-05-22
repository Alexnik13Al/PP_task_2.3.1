package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUser(Long id);
}

