package main.dao.impl;

import main.dao.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserDaoImplTest {


    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private UserDaoImpl userDaoImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            userDaoImpl = new UserDaoImpl(mockConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getUserByEmail_ShouldReturnUserDto_WheValidEmail() {
        try {
            // GIVEN
            String name = "Thomas Smith";
            String email = "thomas@email.com";
            String password = "thomas";
            UserDto userDto = new UserDto(name, email, password);

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true);
            when(mockResultSet.getString("name")).thenReturn(name);
            when(mockResultSet.getString("email")).thenReturn(email);
            when(mockResultSet.getString("password")).thenReturn(password);

            // WHEN
            UserDto resultUserDto = userDaoImpl.getUserByEmail(email);

            // THEN
            verify(mockPreparedStatement).setString(1, email);
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet).next();
            verify(mockResultSet).getString("name");
            verify(mockResultSet).getString("email");
            verify(mockResultSet).getString("password");

            // Assertions
            Assertions.assertEquals(userDto.getName(), resultUserDto.getName());
            Assertions.assertEquals(userDto.getEmail(), resultUserDto.getEmail());
            Assertions.assertEquals(userDto.getPassword(), resultUserDto.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllUsers_ShouldReturnUserDtos_WhenDatabaseHasData() {
        try {
            // GIVEN
            List<UserDto> expectedUserList = new ArrayList<>();
            expectedUserList = List.of(
                    new UserDto("Thomas Smith", "thomas@email.com", "thomas"),
                    new UserDto("Jane Smith", "jane@email.com", "jane")
            );

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false);
            when(mockResultSet.getString("name")).thenReturn("Thomas Smith", "Jane Smith");
            when(mockResultSet.getString("email")).thenReturn("thomas@email.com", "jane@email.com");
            when(mockResultSet.getString("password")).thenReturn("thomas", "jane");

            // WHEN
            List<UserDto> resultUserList = userDaoImpl.getAllUsers();

            // tHEN
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet, times(2)).getString("name");
            verify(mockResultSet, times(2)).getString("email");
            verify(mockResultSet, times(2)).getString("password");

            // Assertions
            Assertions.assertEquals(expectedUserList.size(), resultUserList.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inserUser_ShouldInsertUser_WhenValidUserDto() {
        try {
            // GIVEN
            String name = "Thomas Smith";
            String email = "thomas@email.com";
            String password = "thomas";
            UserDto userDto = new UserDto(name, email, password);

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            userDaoImpl.inserUser(userDto);

            // THEN
            verify(mockPreparedStatement).setString(1, name);
            verify(mockPreparedStatement).setString(2, email);
            verify(mockPreparedStatement).setString(3, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateUser_ShouldUpdateUser_WhenValidExpenseDto() {
        try {
            // GIVEN
            String name = "Jane Smith";
            String email = "jane@email.com";
            String password ="jane";
            UserDto userDto = new UserDto(name, email, password);

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            userDaoImpl.updateUser(userDto);

            // THEN
            verify(mockPreparedStatement).setString(1, name);
            verify(mockPreparedStatement).setString(2, email);
            verify(mockPreparedStatement).setString(3, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteUser_ShouldDeleteUser_WhenValidId() {
        try {
            // GIVEN
            int userId = 1;

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            userDaoImpl.deleteUser(userId);

            // THEN
            verify(mockPreparedStatement).setInt(1, userId);
            verify(mockPreparedStatement).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}