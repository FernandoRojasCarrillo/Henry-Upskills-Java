package main.dao;

import main.dao.dto.CategoryDto;

import java.util.List;

public interface CategoryDao {

    CategoryDto getCategoryByName(String categoryName, int userKey);

    List<CategoryDto> getAllCategories(int userKey);

    void insertCategory(CategoryDto categoryDto, int userKey);

    void updateCategory(CategoryDto categoryDto);

    void deleteCategory(int categoryId);
}
