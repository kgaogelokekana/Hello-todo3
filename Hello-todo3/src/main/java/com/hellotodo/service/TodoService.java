/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hellotodo.service;

import com.hellotodo.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Vivi
 */
@Transactional
public class TodoService {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo){
        //Persist into db
        entityManager.persist(todo);
        return todo;
        
    }
    
    public Todo updateTodo(Todo todo){
        
        entityManager.merge(todo);
        return todo;
        
    }
    
    public Todo findToDoById(Long id){
        
        return entityManager.find(Todo.class, id);
        
    }
    
    public List<Todo> getTodos(){
        
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
        
    }
    
}
