package main.dao;

import main.dao.dto.UserDto;

import java.util.List;

public interface UserDao {

    UserDto getUserByEmail(String userEmail);

    List<UserDto> getAllUsers();

    void inserUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(int userId);

}
