package com.demo.app.config;

import com.demo.app.mapper.CategoryMapper;
import com.demo.app.mapper.ItemMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfiguration {
    @Bean
    public ItemMapper itemMapper() {
        return Mappers.getMapper(ItemMapper.class);
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return Mappers.getMapper(CategoryMapper.class);
    }
}