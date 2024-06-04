package com.demo.app.repository;

import com.demo.app.model.Category;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CategoryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT * FROM category", (rs, rowNum) -> new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description")));
    }

    public Category findById(int categoryId) {
        String sql = "SELECT * FROM category WHERE category_id = :category_id";
        Map<String, Object> params = new HashMap<>();
        params.put("category_id", categoryId);
        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description"))
        );
    }

    public Category findByName(String name) {
        String sql = "SELECT * FROM category WHERE name = :name";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description"))
        );
    }

    public void save(Category category) {
        String sql = "INSERT INTO category (name, description) VALUES (:name, :description)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", category.getName());
        params.put("description", category.getDescription());
        jdbcTemplate.update(sql, params);
    }
}