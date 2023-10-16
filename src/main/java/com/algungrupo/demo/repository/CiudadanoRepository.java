
package com.algungrupo.demo.repository;

import com.algungrupo.demo.controller.domain.Ciudadano;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Integer>{
    
    @Query(value ="select * from ciudadano order by id desc  limit 1", nativeQuery = true)
    List<Ciudadano> findTopByIdByOrderByLevelDesc();
   
}


