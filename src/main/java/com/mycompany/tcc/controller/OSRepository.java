package com.mycompany.tcc.controller;

import com.mycompany.tcc.model.OS;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Elton
 */
public interface OSRepository extends JpaRepository<OS,String>{

    @Query("select o from OS o where o.observacao like concat('%',:observacao,'%')") 
    List<OS> findByVersion(String version);
    
}


//Select com join Select o from OS o join Equipamento e ON (e.cod_equipamento_serial = o.cod_equipamento_serial AND e.setor_int = 1)
