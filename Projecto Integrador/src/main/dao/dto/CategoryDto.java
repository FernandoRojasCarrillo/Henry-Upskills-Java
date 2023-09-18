package main.dao.dto;

public class CategoryDto {
    private int category_id;
    private int user_key;
    private String name;

    public CategoryDto () {}

    public CategoryDto(int userKey, String name) {
        this.user_key = userKey;
        this.name = name;
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_key() {
        return user_key;
    }

    public void setUser_key(int user_key) {
        this.user_key = user_key;
    }
}
