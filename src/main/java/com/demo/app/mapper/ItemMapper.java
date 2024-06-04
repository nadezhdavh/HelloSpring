package com.demo.app.mapper;


import com.demo.app.dto.ItemDTO;
import com.demo.app.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ItemMapper {

    @Mapping(target = "itemId", ignore = true)
    Item toItem(ItemDTO itemDTO);
}