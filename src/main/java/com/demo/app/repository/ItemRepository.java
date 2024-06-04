package com.demo.app.repository;

import com.demo.app.model.Item;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ItemRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> findAll() {
        return jdbcTemplate.query("SELECT * FROM item", (rs, rowNum) ->
                new Item(rs.getInt("item_id"), rs.getInt("category_id"), rs.getString("name"), rs.getString("description"), rs.getBigDecimal("price"))
        );
    }

    public Item findById(int itemId) {
        String sql = "SELECT * FROM item WHERE item_id = :item_id";
        Map<String, Object> params = new HashMap<>();
        params.put("item_id", itemId);
        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                new Item(rs.getInt("item_id"), rs.getInt("category_id"), rs.getString("name"), rs.getString("description"), rs.getBigDecimal("price"))
        );
    }

    public void save(Item item) {
        String sql = "INSERT INTO item (category_id, name, description, price) VALUES (:category_id, :name, :description, :price)";
        Map<String, Object> params = new HashMap<>();
        params.put("category_id", item.getCategoryId());
        params.put("name", item.getName());
        params.put("description", item.getDescription());
        params.put("price", item.getPrice());
        jdbcTemplate.update(sql, params);
    }
}