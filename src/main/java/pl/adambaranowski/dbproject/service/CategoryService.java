package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Author;
import pl.adambaranowski.dbproject.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addCategory", query = "INSERT INTO categories (name) VALUES ?;")
@NamedNativeQuery(name = "deleteCategoryById", query = "DELETE FROM categories WHERE category_id=?;")
@NamedNativeQuery(name = "deleteCategoryByName", query = "DELETE FROM categories WHERE name=?;")
@NamedNativeQuery(name = "getCategoryById", query = "SELECT FROM  categories WHERE category_id=? LIMIT 1;")
@NamedNativeQuery(name = "getCategoryByName", query = "SELECT FROM categories WHERE name=? LIMIT 1;")
@NamedNativeQuery(name = "getAllCategories", query = "SELECT * FROM categories;")
public class CategoryService {

    private EntityManager entityManager;

    @Autowired
    public CategoryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addCategory(String name){
        Query query = entityManager.createNativeQuery("addCategory");
        query.setParameter(1, name);
        query.executeUpdate();
    }

    public void deleteCategoryById(int category_id){
        Query query = entityManager.createNativeQuery("deleteCategoryById");
        query.setParameter(1, category_id);
        query.executeUpdate();
    }

    public void deleteCategoryByName(String name){
        Query query = entityManager.createNativeQuery("deleteCategoryByName");
        query.setParameter(1, name);
        query.executeUpdate();
    }

    public Category getCategoryByName(String name){
        Query query = entityManager.createNativeQuery("getCategoryByName", Category.class);
        query.setParameter(1, name);
        List resultList = query.getResultList();
        return (Category) resultList.get(0);
    }

    public Category getCategoryById(int category_id){
        Query query = entityManager.createNativeQuery("getCategoryById", Category.class);
        query.setParameter(1, category_id);
        List resultList = query.getResultList();
        return (Category) resultList.get(0);
    }

    public List<Category> getAllCategories(){
        Query query = entityManager.createNativeQuery("getAllCategories", Category.class);
        List<Category> resultList = query.getResultList();
        return resultList;
    }

}
