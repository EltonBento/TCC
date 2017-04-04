/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "tipomanutencao")
public class TipoManutencao {
    
    
    @Id
    private Integer cod_tipomanutencao_serial;
    
    @Column(name= "descricao")
    private String descricao;
    
    
    
    public TipoManutencao(){}

    public TipoManutencao(Integer cod_tipomanutencao_serial, String descricao) {
        this.cod_tipomanutencao_serial = cod_tipomanutencao_serial;
        this.descricao = descricao;
    }

    public Integer getCod_tipomanutencao_serial() {
        return cod_tipomanutencao_serial;
    }

    public void setCod_tipomanutencao_serial(Integer cod_tipomanutencao_serial) {
        this.cod_tipomanutencao_serial = cod_tipomanutencao_serial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
