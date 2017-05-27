package com.mycompany.tcc.model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Elton
 */

@Entity
@Table(name = "equipamento")
public class Equipamento {
    
    @Id
    private Integer cod_equipamento_serial;
    
    @Column(name= "cod_equipamento_nominal")
    private String cod_equipamento_nominal;
    
    @Column(name= "setordescricao")
    private String setordescricao;
    
    
    @OneToMany(mappedBy = "setor")
    private List<OS> listOS;
    
    

    public Equipamento(){}
    
    public Equipamento(Integer cod_equipamento_serial, String cod_equipamento_nominal, String setordescricao) {
        this.cod_equipamento_serial = cod_equipamento_serial;
        this.cod_equipamento_nominal = cod_equipamento_nominal;
        this.setordescricao = setordescricao;
    }
    
        
    
    public Integer getCod_equipamento_serial() {
        return cod_equipamento_serial;
    }

    public void setCod_equipamento_serial(Integer cod_equipamento_serial) {
        this.cod_equipamento_serial = cod_equipamento_serial;
    }

    
    public String getCod_equipamento_nominal() {
        return cod_equipamento_nominal;
    }

    public void setCod_equipamento_nominal(String cod_equipamento_nominal) {
        this.cod_equipamento_nominal = cod_equipamento_nominal;
    }

    
    public String getSetordescricao() {
        return setordescricao;
    }

    public void setSetordescricao(String setordescricao) {
        this.setordescricao = setordescricao;
    }

      
    
        
}
