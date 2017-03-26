/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.OS;
import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Elton
 */
public interface OSRepository extends JpaRepository<OS,String>{

    //public List<OS> findByObservacao();
    @Query("select o from OS o where o.observacao like concat('%',:observacao,'%')") 
    List<OS> findByVersion(String version);
    
   
    
}
