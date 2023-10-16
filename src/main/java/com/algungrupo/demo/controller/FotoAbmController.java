package com.algungrupo.demo.controller;

import com.algungrupo.demo.controller.domain.Foto;
import com.algungrupo.demo.service.FotoService;
import com.algungrupo.demo.service.ReporteService;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FotoAbmController {
    
    private final FotoService fotoService;
    private final ReporteService reporteService;
   

    public FotoAbmController(FotoService fotoService, ReporteService reporteService) {
        this.fotoService = fotoService;
        this.reporteService = reporteService;
    }

 

    
    
    @RequestMapping("/reportes3/crear")
    public String mostrarFormReporte(Model model){
        model.addAttribute("reporte", new Foto());
        model.addAttribute("reportes", reporteService.buscarUltimo());
    return "form_reporte3";
    }
    
    /* @PostMapping("/reportes3/guardar")
     public String uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files){
     
     
     try{
        fotoService.saveMultipleFiles(files);
        
        } catch (IOException e){
        e.printStackTrace();
        }
      

     
      return "redirect:/ciudadanosLista";
     }*/
            
    
    
     @PostMapping("/reportes3/guardar")
     
         
     public String uploadMultipleFiles(@ModelAttribute Foto foto, BindingResult result, 
            Model model, @RequestParam("files") List<MultipartFile> files, RedirectAttributes attribute){
         
         
     
     try{
        fotoService.saveMultipleFiles(files);
   
             String cadena = files.get(0).getOriginalFilename();
             String cadena2 = files.get(1).getOriginalFilename();
             String cadena3 = files.get(2).getOriginalFilename();
             String cadena4 = files.get(3).getOriginalFilename();
             String cadena5 = files.get(4).getOriginalFilename();
             foto.setFoto1(cadena);
             foto.setFoto2(cadena2);
             foto.setFoto3(cadena3);
             foto.setFoto4(cadena4);
             foto.setFoto5(cadena5);
         
        //foto.setFoto1(files.getOriginalFilename());
        
        } catch (IOException e){
        e.printStackTrace();
        }
       
         fotoService.guardar(foto);   
     
      return "redirect:/ciudadanosLista";
     }
    
  
   
 /* @PostMapping("/reportes3/guardar")
    public String guardar(@ModelAttribute Foto foto, BindingResult result, 
            Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute){
        
        if(!imagen.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static/fotos");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path  rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                
               //foto1.setImagen(imagen.getOriginalFilename());
               foto.setFoto1(imagen.getOriginalFilename());
               
                
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            
            
        }
        fotoService.guardar(foto);
    return "redirect:/ciudadanosLista";
    }*/

    
    
   /* @PostMapping("/reportes3/guardar")
    public String guardar(Foto foto){
        
        fotoService.guardar(foto);
    return "redirect:/ciudadanosLista";
    }*/
    
    
}
