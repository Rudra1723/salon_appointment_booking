package com.sb.category_service.service;

import com.sb.category_service.dto.SaloonDTO;
import com.sb.category_service.model.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SaloonDTO saloonDTO);
    Set<Category> getAllCategoriesBySaloon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id,Long saloonId) throws Exception;

}
