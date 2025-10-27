package com.sb.category_service.controller;

import com.sb.category_service.model.Category;
import com.sb.category_service.repository.CategoryRepository;
import com.sb.category_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @GetMapping("/saloon/{id}")
    public ResponseEntity<Set<Category>> getCategoriesBySaloon(
            @PathVariable long id
    )
    {
        Set<Category> categories = categoryService.getAllCategoriesBySaloon(id);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoriesById(
            @PathVariable long id
    )throws Exception
    {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }


}
