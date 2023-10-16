
package com.algungrupo.demo.controller;

import com.algungrupo.demo.controller.domain.Ciudadano;
import com.algungrupo.demo.controller.domain.Reporte;
import com.algungrupo.demo.service.CiudadanoService;
import com.algungrupo.demo.service.ReporteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListadoController {
    
    private final ReporteService reporteService;
    private final CiudadanoService ciudadanoService;

    public ListadoController(ReporteService reporteService, CiudadanoService ciudadanoService) {
        this.reporteService = reporteService;
        this.ciudadanoService = ciudadanoService;
    }

  
    
    @RequestMapping("/")
    public String listarReportes(Model model){
        List<Reporte> destacados = reporteService.buscarDestacados();
        model.addAttribute("reportes", destacados);
        return "listado";
    
    }
    
    @RequestMapping("/ciudadanosLista")
    public String listarCiudadanos(Model model){
        List<Ciudadano> consultados = ciudadanoService.buscarCiudadanos();
        model.addAttribute("ciudadanos", consultados);
        return "listado_ciudadano";
    
    }
    
   /* @RequestMapping("/ciudadanosUltimo")
    public String UltimoCiudadanos(Model model){
        List<Ciudadano> consultados = ciudadanoService.buscarUltimo();
        model.addAttribute("ciudadanos", consultados);
        return "listado_ciudadano";
    }*/
    
}
