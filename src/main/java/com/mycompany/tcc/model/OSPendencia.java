
package com.mycompany.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */

@Entity
@Table(name = "ospendencia")
public class OSPendencia {
    
@Id
private Integer cod_ospendencia_serial;    

@Column(name = "observacao")
private String observacao;

@Column(name = "cod_os_serial")
private Integer cod_os_serial;


@Column(name = "cod_pendencia_serial")
private Integer cod_pendencia_serial;

    public OSPendencia(Integer cod_ospendencia_serial, String observacao, Integer cod_os_serial, Integer cod_pendencia_serial) {
        this.cod_ospendencia_serial = cod_ospendencia_serial;
        this.observacao = observacao;
        this.cod_os_serial = cod_os_serial;
        this.cod_pendencia_serial = cod_pendencia_serial;
    }

    public OSPendencia(){}

    public Integer getCod_ospendencia_serial() {
        return cod_ospendencia_serial;
    }

    public void setCod_ospendencia_serial(Integer cod_ospendencia_serial) {
        this.cod_ospendencia_serial = cod_ospendencia_serial;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String descricao) {
        this.observacao = observacao;
    }

    public Integer getCod_os_serial() {
        return cod_os_serial;
    }

    public void setCod_os_serial(Integer cod_os_serial) {
        this.cod_os_serial = cod_os_serial;
    }

    public Integer getCod_pendencia_serial() {
        return cod_pendencia_serial;
    }

    public void setCod_pendencia_serial(Integer cod_pendencia_serial) {
        this.cod_pendencia_serial = cod_pendencia_serial;
    }
    
    
            




    
    
    
    
    
    
}
