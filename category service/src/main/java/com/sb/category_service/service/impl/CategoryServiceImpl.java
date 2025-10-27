package com.sb.category_service.service.impl;

import com.sb.category_service.dto.SaloonDTO;
import com.sb.category_service.model.Category;
import com.sb.category_service.repository.CategoryRepository;
import com.sb.category_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SaloonDTO saloonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(saloonDTO.getId());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySaloon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category not found with id " + id));
    }

    @Override
    public void deleteCategoryById(Long id, Long saloonId) throws Exception {
        Category category = getCategoryById(id);
        if (!category.getSalonId().equals(saloonId)) {
            throw new Exception("You don't have permission to delete this category");
        }
        categoryRepository.deleteById(id);
    }
}
