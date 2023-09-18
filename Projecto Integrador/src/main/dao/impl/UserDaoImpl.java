package main.dao.impl;

import main.dao.UserDao;
import main.dao.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.config.jdbcConfig.getConnection;

public class UserDaoImpl implements UserDao {
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM Proyecto_Integrador.UserTable WHERE email = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM Proyecto_Integrador.UserTable";
    private static final String INSERT_USER_INTO_DB = "INSERT INTO Proyecto_Integrador.UserTable(name, email, password) VALUES(?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE Proyecto_Integrador.UserTable SET name = ?, email = ?, password = ? WHERE user_id = ?";
    private static final String DELETE_USER = "DELETE FROM Proyecto_Integrador.UserTable WHERE user_id = ?";

    private final Connection connection;

    public UserDaoImpl() {
        this.connection = getConnection();
    }

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserDto getUserByEmail(String userEmail) {
        try(PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL)) {

            statement.setString(1, userEmail);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResulSetToUserDto(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error when trying to get the user from the database" + e);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS)) {
            List<UserDto> allUsersDto = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                allUsersDto.add(mapResulSetToUserDto(resultSet));
            }

            return allUsersDto;

        } catch (SQLException e) {
            throw new RuntimeException("Error when trying to get the users" + e);
        }
    }

    @Override
    public void inserUser(UserDto userDto) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_USER_INTO_DB)) {

            statement.setString(1, userDto.getName());
            statement.setString(2, userDto.getEmail());
            statement.setString(3, userDto.getPassword());

            int rowsCreated = statement.executeUpdate();
            if (rowsCreated == 0) {
                throw new RuntimeException("Error, user creation unsuccessful");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {

            statement.setString(1, userDto.getName());
            statement.setString(2, userDto.getEmail());
            statement.setString(3, userDto.getPassword());
            statement.setInt(4, userDto.getUser_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("User Update unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error, user updated unsuccessfully" + e);
        }
    }

    @Override
    public void deleteUser(int userId) {
        try(PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {

            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Error, User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error, user deleted unsuccessfully" + e);
        }
    }

    private UserDto mapResulSetToUserDto(ResultSet resultSet) {
        UserDto userDto = new UserDto();
        try {

            userDto.setUser_id(resultSet.getInt("user_id"));
            userDto.setName(String.valueOf(resultSet.getString("name")));
            userDto.setEmail(String.valueOf(resultSet.getString("email")));
            userDto.setPassword(String.valueOf(resultSet.getString("password")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDto;
    }
}
