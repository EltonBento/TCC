package com.mycompany.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */

@Entity
@Table(name = "prioridade")
public class Prioridade {
    
    @Id
    private Integer cod_prioridade_serial;
    
    @Column(name="descricao")
    private String descricao;

    public Prioridade(Integer cod_prioridade_serial, String descricao) {
        this.cod_prioridade_serial = cod_prioridade_serial;
        this.descricao = descricao;
    }
    
    public Prioridade(){}

    public Integer getCod_prioridade_serial() {
        return cod_prioridade_serial;
    }

    public void setCod_prioridade_serial(Integer cod_prioridade_serial) {
        this.cod_prioridade_serial = cod_prioridade_serial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
}
