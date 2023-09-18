package main.dao.impl;

import main.dao.CategoryDao;
import main.dao.dto.CategoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.config.jdbcConfig.getConnection;

public class CategoryDaoImpl implements CategoryDao {

    private final String GET_CATEGORY_BY_NAME = "SELECT * FROM Proyecto_Integrador.CategoryTable WHERE user_key = ? AND name = ?";
    private final String GET_ALL_CATEGORIES = "SELECT * FROM Proyecto_Integrador.CategoryTable WHERE user_key = ?";
    private final String INSERT_CATEGORY_INTO_DB = "INSERT INTO Proyecto_Integrador.CategoryTable(user_key, name) VALUES (?, ?)";
    private final String UPDATE_CATEGORY = "UPDATE Proyecto_Integrador.CategoryTable SET name = ? WHERE category_id = ?";
    private final String DELETE_CATEFORY = "DELETE FROM Proyecto_Integrador.CategoryTable WHERE category_id = ?";

    private final Connection connection;

    public CategoryDaoImpl() {
        this.connection = getConnection();
    }

    public CategoryDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName, int userKey) {
        try (PreparedStatement statement = connection.prepareStatement(GET_CATEGORY_BY_NAME)) {
            statement.setInt(1, userKey);
            statement.setString(2, categoryName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResulSetToCategoryDto(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error, when getting the category by name" + e);
        }
    }

    @Override
    public List<CategoryDto> getAllCategories(int userKey) {
        List<CategoryDto> categories = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_CATEGORIES)) {
            statement.setInt(1, userKey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                categories.add(mapResulSetToCategoryDto(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("There was an error when getting all the categories" + e);
        }
        return categories;
    }

    @Override
    public void insertCategory(CategoryDto categoryDto, int userKey) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY_INTO_DB)) {
            statement.setInt(1, userKey);
            statement.setString(2, categoryDto.getName());

            int rowsCreated = statement.executeUpdate();
            if (rowsCreated == 0) {
                throw new RuntimeException("Error creating the category");
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY)) {
            statement.setString(1, categoryDto.getName());
            statement.setInt(2, categoryDto.getCategory_id());

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated == 0) {
                throw new RuntimeException("Error, category updated unsuccessfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: " + e);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CATEFORY)) {
            statement.setInt(1, categoryId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Error, category id does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException("EEROR: " + e);
        }
    }

    private CategoryDto mapResulSetToCategoryDto(ResultSet resultSet) {
        CategoryDto categoryDto = new CategoryDto();
        try {
            categoryDto.setCategory_id(resultSet.getInt("category_id"));
            categoryDto.setName(resultSet.getString("name"));
            categoryDto.setUser_key(resultSet.getInt("user_key"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryDto;
    }
}
