package com.demo.app.dto;

import java.math.BigDecimal;

public record ItemDTO(String categoryName, String name, String description, BigDecimal price) {
}
