/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.interfaces;

import com.usa.boat.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ruby Dayana
 */
public interface ICategory extends CrudRepository<Category, Integer>{
    
}