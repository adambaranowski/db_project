package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.Category;
import pl.adambaranowski.dbproject.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Object> createNewCategory(@RequestParam String category_name){
        categoryService.addCategory(category_name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @GetMapping("/category_name")
    public ResponseEntity<Category> getCategoryByName(@RequestParam String category_name){
        Category categoryByName = categoryService.getCategoryByName(category_name);
        return new ResponseEntity<>(categoryByName, HttpStatus.OK);
    }

    @GetMapping("/category_id")
    public ResponseEntity<Category> getCategoryById(@RequestParam Integer category_id){
        Category categoryById = categoryService.getCategoryById(category_id);
        return new ResponseEntity<>(categoryById, HttpStatus.OK);
    }

    @DeleteMapping("/category_name")
    public ResponseEntity<Object> deleteCategoryByName(@RequestParam String category_name){
        categoryService.deleteCategoryByName(category_name);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category_id")
    public ResponseEntity<Object> deleteCategoryById(@RequestParam Integer category_id){
        categoryService.deleteCategoryById(category_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
