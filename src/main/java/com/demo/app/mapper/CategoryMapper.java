package com.demo.app.mapper;

import com.demo.app.dto.CategoryDTO;
import com.demo.app.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

    @Mapping(target = "categoryId", ignore = true)
    Category toCategory(CategoryDTO categoryDTO);
}