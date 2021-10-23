/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.repository;

import com.usa.boat.entity.Boat;
import com.usa.boat.entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.boat.interfaces.ICategory;

/**
 *
 * @author Ruby Dayana
 */
@Repository
public class CategoryRepository {

    @Autowired
    private ICategory crud;

    public List<Category> getAll() {
        return (List< Category>) crud.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }

    public Category save(Category category) {
        return crud.save(category);
    }

    public void delete(Category category) {
        crud.delete(category);
    }
}
