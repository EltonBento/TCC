package com.mycompany.tcc.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */

@Entity
@Table(name = "pendencia")
public class Pendencia{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod_pendencia_serial;
    
    @Column(name = "descricao")
    private String descricao;
    
    public Pendencia(){}
    
    public Pendencia(Integer cod_pendencia_serial, String descricao) {
        this.cod_pendencia_serial = cod_pendencia_serial;
        this.descricao = descricao;
    }

    public Integer getCod_pendencia_serial() {
        return cod_pendencia_serial;
    }

    public void setCod_pendencia_serial(Integer cod_pendencia_serial) {
        this.cod_pendencia_serial = cod_pendencia_serial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
