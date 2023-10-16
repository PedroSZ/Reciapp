package com.algungrupo.demo.controller;

import com.algungrupo.demo.controller.domain.Reporte;
import com.algungrupo.demo.service.CiudadanoService;
import com.algungrupo.demo.service.ReporteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReporteAbmController {
    
    private final ReporteService reporteService;
    private final CiudadanoService ciudadanoCervice;

    public ReporteAbmController(ReporteService reporteService, CiudadanoService ciudadanoCervice) {
        this.reporteService = reporteService;
        this.ciudadanoCervice = ciudadanoCervice;
    }

    @RequestMapping("/reportes2/crear")
    public String mostrarFormReporte(Model model){
    model.addAttribute("reporte", new Reporte());
    model.addAttribute("ciudadanos", ciudadanoCervice.buscarUltimo());
    return "form_reporte2";
    }
    
    @PostMapping("/reportes2/guardar")
    public String guardar(Reporte reporte){
        reporteService.guardar(reporte);
    return "redirect:/reportes3/crear";
    }
    
    
     @RequestMapping("/reportePorIdentificador")
     public String LiatarreportePorId(int id, Model model){
        List<Reporte> reportes = reporteService.buscarPorId(id);
        model.addAttribute("reportes", reportes);
        return "reporteActual";
     }
    
   
}
