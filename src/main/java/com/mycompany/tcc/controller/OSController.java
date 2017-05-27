package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.Equipamento;
import com.mycompany.tcc.model.OS;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elton
 */
@RestController
public class OSController {
     
    @PersistenceContext
    private EntityManager manager;
    
  
       
    @RequestMapping(value= "/findAll")                    
    public List<OS> findTeste(){
        return manager.createQuery(
                "select o from OS o",
                OS.class).getResultList();
        
     }
    
    //crossOrigem permite que outros serviços possam acessar essa api 
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByObservacaoVersao")                    
    public List<OS> findByObservacaoVersao(String observacao){
           TypedQuery<OS> query = manager
                .createQuery(
                        "select o from OS o where o.observacao like concat('%',:observacao,'%')"
                                + "and o.situacao='F'",
                        OS.class).setParameter("observacao", observacao);
           List<OS> result = query.getResultList();
           return result;
       
        
     }
    
     
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/setor")                    
    public List<Equipamento> findBySetor(String observacao){
       TypedQuery<Equipamento> query = manager
               .createQuery("select distinct e from Equipamento e join e.listOS o on o.observacao like concat('%',:observacao,'%') "
                        + "and o.situacao='F'",
                       Equipamento.class).setParameter("observacao", observacao);
           List<Equipamento> result = query.getResultList();
          return result;
       
    }
    
    
}
    

