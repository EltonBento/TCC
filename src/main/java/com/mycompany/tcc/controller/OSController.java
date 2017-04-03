/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.OS;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elton
 */
@RestController
public class OSController {
    @Autowired
    OSRepository repositorio;
    
    @PersistenceContext
    private EntityManager manager;
    
    @RequestMapping(value = "/findAll") 
    public List<OS> findall(){
        return repositorio.findAll();
    }
    
    
    @RequestMapping(value = "/findTeste")                    
    public List<OS> findTeste(){
        return manager.createQuery(
                "select o from OS o",
                OS.class).getResultList();
        
     }
    
    @RequestMapping(value = "/findByObservacaoVersao")                    
    public List<OS> findByObservacaoVersao(String observacao){
           TypedQuery<OS> query = manager
                .createQuery(
                        "select o from OS o where o.observacao like concat('%',:observacao,'%')",
                        OS.class).setParameter("observacao", observacao);
           List<OS> result = query.getResultList();
           return result;
       
        
     }
    
    @RequestMapping(value = "/findBySetor")                    
    public List<OS> findBySetorVersao(Integer cod_setor_serial, String observacao){
           TypedQuery<OS> query = manager
                .createQuery(
                        "select o from OS o where o.cod_setor_serial=:cod_setor_serial "
                                + "and o.observacao like concat('%',:observacao,'%')",
                        OS.class).setParameter("cod_setor_serial", cod_setor_serial).setParameter("observacao", observacao);
           List<OS> result = query.getResultList();
           return result;
     }
    
    
       
}
    

