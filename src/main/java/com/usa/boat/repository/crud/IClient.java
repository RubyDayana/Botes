/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.repository.crud;

import com.usa.boat.entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ruby Dayana
 */
public interface IClient extends CrudRepository<Client, Integer>{
    
}
