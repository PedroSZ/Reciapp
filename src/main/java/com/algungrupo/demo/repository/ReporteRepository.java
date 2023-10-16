
package com.algungrupo.demo.repository;

import com.algungrupo.demo.controller.domain.Foto;
import com.algungrupo.demo.controller.domain.Reporte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReporteRepository extends JpaRepository<Reporte, Integer>{
    
    @Query(value ="select * from reporte order by id desc  limit 1", nativeQuery = true)
    List<Reporte> findTopByIdByOrderByLevelDesc();
    
    //@Query("Reporte r where r.reporte.id = ?1 order by r.nombre")
    @Query(value ="select * from reporte where id = ?1", nativeQuery = true)
    List<Reporte> findById(int id);
}
