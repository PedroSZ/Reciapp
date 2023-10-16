package com.algungrupo.demo.controller;

import com.algungrupo.demo.controller.domain.Ciudadano;
import com.algungrupo.demo.controller.domain.Reporte;
import com.algungrupo.demo.service.CiudadanoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CiudadanoAbmController {
    
    private final CiudadanoService ciudadanoService;

    public CiudadanoAbmController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    
    
    
    @RequestMapping("/reportes/crear")
    public String mostrarFormReporte(Model model){
        model.addAttribute("reporte", new Ciudadano());
    return "form_reporte";
    }
    
    @PostMapping("/reportes/guardar")
    public String guardar(Ciudadano ciudadano){
        ciudadanoService.guardar(ciudadano);
    return "redirect:/reportes2/crear";
    }
    
   
}
