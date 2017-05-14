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
