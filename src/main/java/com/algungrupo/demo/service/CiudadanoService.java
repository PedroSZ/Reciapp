package com.algungrupo.demo.service;

import com.algungrupo.demo.controller.domain.Ciudadano;
import com.algungrupo.demo.repository.CiudadanoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoService {
    
    private final CiudadanoRepository ciudadanorepository;

    public CiudadanoService(CiudadanoRepository ciudadanorepository) {
        this.ciudadanorepository = ciudadanorepository;
    }

    public List<Ciudadano> buscarCiudadanos() {
        return ciudadanorepository.findAll();
    }
    
    public Ciudadano guardar(Ciudadano ciudadano){
    return ciudadanorepository.save(ciudadano);
    }
    
     public List<Ciudadano> buscarUltimo() {
        return ciudadanorepository.findTopByIdByOrderByLevelDesc();//findTopByOrderByLevelDesc();
    }
   
    
   
}
