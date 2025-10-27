package com.sb.category_service.controller;

import com.sb.category_service.dto.SaloonDTO;
import com.sb.category_service.model.Category;
import com.sb.category_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories/saloon-owner")
public class SaloonCategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity <Category> createCategory(
            @RequestBody Category category
    )
    {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);
       Category savedCategory = categoryService.saveCategory(category,saloonDTO);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteCategory(
            @PathVariable Long id
    ) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        categoryService.deleteCategoryById(id,saloonDTO.getId());
        return ResponseEntity.ok("Deleted Category Successfully");
    }



}
