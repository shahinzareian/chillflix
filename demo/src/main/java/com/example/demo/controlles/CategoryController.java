package com.example.demo.controlles;

import com.example.demo.models.Admin;
import com.example.demo.models.Category;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategories(){return categoryRepository.findAll();}

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryRepository.findById(id).get();
    }

    @PostMapping
    public Long addCategory(@RequestBody Category category) {
        Category createCategory=  categoryRepository.save(category);
        return createCategory.getId();
    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        category.setId(id);
        categoryRepository.save(category);
    }
}
