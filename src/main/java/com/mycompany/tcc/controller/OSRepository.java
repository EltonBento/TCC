/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.OS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author Elton
 */
public interface OSRepository extends JpaRepository<OS,String>{

    //List<OS> findBySetor(Integer cod_setor_serial);
           
           
    @Query("select o from OS o where o.observacao like concat('%',:observacao,'%')") 
    List<OS> findByVersion(String version);
    
    //@Query("select o from OS o where o.cod_setor_serial = :cod_setor_serial and o.observacao like concat('%',:observacao,'%')")
    //List<OS> findBySetor(Integer cod_setor_serial,String observacao);
    
    
}
