/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.service;

import com.usa.boat.entity.Category;
import com.usa.boat.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author RubyDayana
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return metodosCrud.getCategory(id);
    }
    
    public Category save(Category category) {
        if (category.getId() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> evtCategory = metodosCrud.getCategory(category.getId());
            if(evtCategory.isEmpty()){
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }
    
    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> evtCategory = metodosCrud.getCategory(category.getId());
            if (!evtCategory.isEmpty()) {
                
                if (category.getDescription()!= null) {
                    evtCategory.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    evtCategory.get().setName(category.getName());
                }
                metodosCrud.save(evtCategory.get());
                return evtCategory.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean deleteCategory(int categoryId) {
        Boolean booleanDelete = getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return booleanDelete;
    }
    
}
