package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.Equipamento;
import com.mycompany.tcc.model.OS;
import com.mycompany.tcc.model.Ocorrencia;
import com.mycompany.tcc.model.Pendencia;
import com.mycompany.tcc.model.Prioridade;
import com.mycompany.tcc.model.TipoManutencao;
import java.util.ArrayList;

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
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/versao")                    
    public List<String> listVersao(){
       TypedQuery<OS> query = manager.createQuery("select o from OS o",OS.class);
       List<OS> result = query.getResultList();
       List<String> lista = new ArrayList();
                 
       String strVazia = "";
       for(OS obj:result){
               if(!strVazia.equals(obj.getObservacao()) && obj.getObservacao()!= null){
                   if(obj.getObservacao().length()>=6){ 
                       if(!lista.contains((obj.getObservacao().substring(0, 6)))){
                            if(obj.getObservacao().substring(0,2).equals("V ") && obj.getObservacao().substring(3,4).equals(".")){
                                lista.add(obj.getObservacao().substring(0, 6));
                            }
                        }
                   }
                }
        }
        return lista;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllOS")                    
    public List<OS> findAllOS(){
       TypedQuery<OS> query = manager
               .createQuery("select o from OS o", OS.class);
           List<OS> result = query.getResultList();
          return result;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findOSByCodNominal")                    
    public OS findOSByCodNominal(String cod_os_nominal){
       TypedQuery<OS> query = manager
               .createQuery("select o from OS o where o.cod_os_nominal=:cod_os_nominal", OS.class).setParameter("cod_os_nominal", cod_os_nominal);;
           OS result = query.getSingleResult();
          return result;
    }
    
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllEquipamento")                    
    public List<Equipamento> findAllEquipamento(){
       TypedQuery<Equipamento> query = manager
               .createQuery("select e from Equipamento e", Equipamento.class);
           List<Equipamento> result = query.getResultList();
          return result;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findEquipamentoByCodEquipNominal")                    
    public Equipamento findEquipamentoByCodEquipNominal(String cod_equipamento_nominal){
       TypedQuery<Equipamento> query = manager
               .createQuery("select e from Equipamento e where e.cod_equipamento_nominal=:cod_equipamento_nominal", Equipamento.class).setParameter("cod_equipamento_nominal", cod_equipamento_nominal);
           Equipamento result = query.getSingleResult();
          return result;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllOcorrencia")                    
    public List<Ocorrencia> findAllOcorrencia(){
       TypedQuery<Ocorrencia> query = manager
               .createQuery("select oc from Ocorrencia oc", Ocorrencia.class);
           List<Ocorrencia> result = query.getResultList();
          return result;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findOcorrenciaByCodOcorSerial")                    
    public Ocorrencia findOcorrenciaByCodOcorSerial(Integer cod_ocorrencia_serial){
       TypedQuery<Ocorrencia> query = manager
               .createQuery("select oc from Ocorrencia oc where oc.cod_ocorrencia_serial=:cod_ocorrencia_serial", Ocorrencia.class).setParameter("cod_ocorrencia_serial", cod_ocorrencia_serial);
           Ocorrencia result = query.getSingleResult();
          return result;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllPendencia")                    
    public List<Pendencia> findAllPendencia(){
       TypedQuery<Pendencia> query = manager
               .createQuery("select pe from Pendencia pe", Pendencia.class);
           List<Pendencia> result = query.getResultList();
          return result;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findPendenciaByCodPendSerial")                    
    public Pendencia findPendenciaByCodPendSerial(Integer cod_pendencia_serial){
       TypedQuery<Pendencia> query = manager
               .createQuery("select pe from Pendencia pe where pe.cod_pendencia_serial=:cod_pendencia_serial", Pendencia.class).setParameter("cod_pendencia_serial", cod_pendencia_serial);
           Pendencia result = query.getSingleResult();
          return result;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllPrioridade")                    
    public List<Prioridade> findAllPrioridade(){
       TypedQuery<Prioridade> query = manager
               .createQuery("select pr from Prioridade pr", Prioridade.class);
           List<Prioridade> result = query.getResultList();
          return result;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findPrioridadeByCodPrioSerial")                    
    public Prioridade findPrioridadeByCodPrioSerial(Integer cod_prioridade_serial){
       TypedQuery<Prioridade> query = manager
               .createQuery("select pr from Prioridade pr where pr.cod_prioridade_serial=:cod_prioridade_serial", Prioridade.class).setParameter("cod_prioridade_serial", cod_prioridade_serial);
           Prioridade result = query.getSingleResult();
          return result;
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllTipoManutencao")                    
    public List<TipoManutencao> findAllTipoManutencao(){
       TypedQuery<TipoManutencao> query = manager
               .createQuery("select tm from TipoManutencao tm", TipoManutencao.class);
           List<TipoManutencao> result = query.getResultList();
          return result;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findTipoManutencaoByCodTMSerial")                    
    public TipoManutencao findTipoManutencaoByCodTMSerial(Integer cod_tipomanutencao_serial){
       TypedQuery<TipoManutencao> query = manager
               .createQuery("select tm from TipoManutencao tm where tm.cod_tipomanutencao_serial=:cod_tipomanutencao_serial", TipoManutencao.class).setParameter("cod_tipomanutencao_serial", cod_tipomanutencao_serial);
           TipoManutencao result = query.getSingleResult();
          return result;
    }
    
    
}
    

