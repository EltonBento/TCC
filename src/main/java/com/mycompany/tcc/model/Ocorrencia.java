/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcc.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {
    
    @Id
    private Integer cod_ocorrencia_serial;
    
    @Column(name= "descricao")
    private String descricao;
    
    @ManyToMany(mappedBy = "ocorrencias")
    private List<OS> listOS;
    

    public Ocorrencia(Integer cod_ocorrencia_serial, String descricao) {
        this.cod_ocorrencia_serial = cod_ocorrencia_serial;
        this.descricao = descricao;
    }
    
    public Ocorrencia(){}

    public Integer getCod_ocorrencia_serial() {
        return cod_ocorrencia_serial;
    }

    public void setCod_ocorrencia_serial(Integer cod_ocorrencia_serial) {
        this.cod_ocorrencia_serial = cod_ocorrencia_serial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
