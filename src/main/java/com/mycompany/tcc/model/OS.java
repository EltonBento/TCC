/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcc.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */
@Entity
@Table(name = "os")
public class OS{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod_os_serial;
    
    @Column(name = "cod_os_nominal")
    private String cod_os_nominal;
    
    @Column(name = "cod_setor_serial")
    private Integer cod_setor_serial;
    
    @Column(name = "cod_tipomanutencao_serial")
    private Integer cod_TipoManutencao_serial;
    
    @Column(name = "prioridade")
    private Integer prioriadade;
    
    @Column(name = "situacao")
    private String situacao;
    
    @Column(name = "observacao")
    private String observacao;
    
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ospendencia",
            joinColumns = @JoinColumn(name = "cod_os_serial",referencedColumnName = "cod_os_serial"),
            inverseJoinColumns = @JoinColumn(name = "cod_pendencia_serial", referencedColumnName = "cod_pendencia_serial" ))
    private List<Pendencia> pendencias;

    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "osocorrenciaservico",
            joinColumns = @JoinColumn(name = "cod_os_serial",referencedColumnName = "cod_os_serial"),
            inverseJoinColumns = @JoinColumn(name = "cod_ocorrencia_serial", referencedColumnName = "cod_ocorrencia_serial" ))
    private List<Ocorrencia> ocorrencias;
    
    public OS(){}

    public OS(Integer cod_os_serial, String cod_os_nominal, Integer cod_setor_serial, Integer cod_TipoManutencao_serial, Integer prioriadade, String situacao, String observacao, List<Pendencia> pendencia, List<Ocorrencia> ocorrencias) {
        this.cod_os_serial = cod_os_serial;
        this.cod_os_nominal = cod_os_nominal;
        this.cod_setor_serial = cod_setor_serial;
        this.cod_TipoManutencao_serial = cod_TipoManutencao_serial;
        this.prioriadade = prioriadade;
        this.situacao = situacao;
        this.observacao = observacao;
        this.pendencias = pendencia;
        this.ocorrencias = ocorrencias;
        
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    
    
    
    
    public List<Pendencia> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }

    

    public Integer getCod_os_serial() {
        return cod_os_serial;
    }

    public void setCod_os_serial(Integer cod_os_serial) {
        this.cod_os_serial = cod_os_serial;
    }

    public String getCod_os_nominal() {
        return cod_os_nominal;
    }

    public void setCod_os_nominal(String cod_os_nominal) {
        this.cod_os_nominal = cod_os_nominal;
    }

    public Integer getCod_setor_serial() {
        return cod_setor_serial;
    }

    public void setCod_setor_serial(Integer cod_setor_serial) {
        this.cod_setor_serial = cod_setor_serial;
    }

    public Integer getCod_TipoManutencao_serial() {
        return cod_TipoManutencao_serial;
    }

    public void setCod_TipoManutencao_serial(Integer cod_TipoManutencao_serial) {
        this.cod_TipoManutencao_serial = cod_TipoManutencao_serial;
    }

    public Integer getPrioriadade() {
        return prioriadade;
    }

    public void setPrioriadade(Integer prioriadade) {
        this.prioriadade = prioriadade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

   public void setObservacao(String observacao) {
       this.observacao = observacao;
    }

    
  
    
    
}
