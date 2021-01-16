package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Category;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Service
public class CategoryService {

    private static final String ADD_CATEGORY = "INSERT INTO categories (name) VALUE (?);";
    private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM categories WHERE category_id=?;";
    private static final String DELETE_CATEGORY_BY_NAME = "DELETE FROM categories WHERE name=?;";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM  categories WHERE category_id=? LIMIT 1;";
    private static final String GET_CATEGORY_BY_NAME = "SELECT * FROM categories WHERE name=? LIMIT 1;";
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM categories;";

    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    @Autowired
    public CategoryService(JdbcTemplate template) {
        this.template = template;
    }

    public void addCategory(String category_name){
        template.update(ADD_CATEGORY, category_name);
    }

    public void deleteCategoryById(int category_id){
        template.update(DELETE_CATEGORY_BY_ID, category_id);
    }

    public void deleteCategoryByName(String category_name){
        template.update(DELETE_CATEGORY_BY_NAME, category_name);
    }

    public Category getCategoryByName(String category_name){
        List<Category> query = template.query(GET_CATEGORY_BY_NAME, rowMapper, category_name);
        return query.get(0);
    }

    public Category getCategoryById(int category_id){
        List<Category> query = template.query(GET_CATEGORY_BY_ID, rowMapper, category_id);
        return query.get(0);
    }

    public List<Category> getAllCategories(){
        List<Category> query = template.query(GET_ALL_CATEGORIES, rowMapper);
        return query;
    }
}
