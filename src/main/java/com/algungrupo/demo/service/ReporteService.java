package com.algungrupo.demo.service;

import com.algungrupo.demo.controller.domain.Reporte;
import com.algungrupo.demo.repository.ReporteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {
    
    private final ReporteRepository reporteRepostory;
    

    public ReporteService(ReporteRepository reporteRepostory) {
        this.reporteRepostory = reporteRepostory;
    }
    

    public List<Reporte> buscarDestacados() {
        return reporteRepostory.findAll();
    }
    
    public Reporte guardar(Reporte reporte){
    return reporteRepostory.save(reporte);
    }
    
     public List<Reporte> buscarUltimo() {
        return reporteRepostory.findTopByIdByOrderByLevelDesc();//findTopByOrderByLevelDesc();
    }
     
     public List<Reporte> buscarPorId(int id){
     return reporteRepostory.findById(id);
     }
   

}
