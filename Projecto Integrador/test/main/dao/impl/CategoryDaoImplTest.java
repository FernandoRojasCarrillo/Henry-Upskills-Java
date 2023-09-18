package main.dao.impl;

import main.dao.dto.CategoryDto;
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

class CategoryDaoImplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @Mock
    private CategoryDaoImpl categoryDaoImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            categoryDaoImpl = new CategoryDaoImpl(mockConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getCategoryByName_ShouldReturnExpenseCategory_WhenValidName() {

        try {
            // GIVEN
            String categoryName = "Groceries";
            int categoryId = 1;
            int userKey = 1;

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true);
            when(mockResultSet.getInt("category_id")).thenReturn(categoryId);
            when(mockResultSet.getInt("user_key")).thenReturn(userKey);
            when(mockResultSet.getString("name")).thenReturn(categoryName);

            // WHEN
            CategoryDto resultCategory = categoryDaoImpl.getCategoryByName(categoryName, userKey);

            // THEN
            verify(mockPreparedStatement).setInt(1, userKey);
            verify(mockPreparedStatement).setString(2, categoryName);
            verify(mockResultSet).next();
            verify(mockResultSet).getInt("category_id");
            verify(mockResultSet).getString("name");

            // Assertions
            assert resultCategory != null;
            assert resultCategory.getCategory_id() == categoryId;
            assert resultCategory.getUser_key() == userKey;
            assert resultCategory.getName() == categoryName;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllCategories_ShouldReturnCategoryDtos_WhenDatabaseHasData() {
        try {
            // GIVEN
            int userKey = 1;
            List<CategoryDto> expectedList = new ArrayList<>();
            expectedList = List.of(
                    new CategoryDto(userKey, "Groceries"),
                    new CategoryDto(userKey, "SchoolAssets")
            );

            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false);
            when(mockResultSet.getInt("user_key")).thenReturn(userKey, userKey);
            when(mockResultSet.getString("name")).thenReturn("Groceries", "SchoolAssets");

            // WHEN
            List<CategoryDto> resultList = categoryDaoImpl.getAllCategories(userKey);

            // THEN
            verify(mockPreparedStatement).executeQuery();
            verify(mockResultSet, times(2)).getInt("user_key");
            verify(mockResultSet, times(2)).getString("name");

            // Assertions
            Assertions.assertEquals(expectedList.size(), resultList.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void insertCategory_ShouldInsertCategory_WhenValidCategoryDto() {
        // GIVEN
        CategoryDto categoryDto = new CategoryDto();
        int userKey = 1;

        try {
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            categoryDaoImpl.insertCategory(categoryDto, userKey);

            // THEN
            verify(mockPreparedStatement).setInt(1, userKey);
            verify(mockPreparedStatement).setString(2, categoryDto.getName());
            verify(mockPreparedStatement).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateCategory_ShouldUpdateCategory_WhenValidCategoryDto() {
        try {
            // GIVEN
            int userKey = 1;
            String name = "Groceries";
            CategoryDto categoryDto = new CategoryDto(userKey, name);

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            categoryDaoImpl.updateCategory(categoryDto);

            // THEN
            verify(mockPreparedStatement).setString(1, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteCategory_ShouldDeleteCategory_WhenValidId() {
        try {
            // GIVEN
            int categoryId = 1;

            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // WHEN
            categoryDaoImpl.deleteCategory(categoryId);

            // THEN
            verify(mockPreparedStatement).setInt(1, categoryId);
            verify(mockPreparedStatement).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}