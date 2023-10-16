package com.algungrupo.demo.service;

import com.algungrupo.demo.controller.domain.Foto;
import com.algungrupo.demo.repository.FotoRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {
    
    private final FotoRepository fotoRepostory;

    public FotoService(FotoRepository fotoRepostory) {
        this.fotoRepostory = fotoRepostory;
    }
    

   

    public List<Foto> buscarDestacadas() {
        return fotoRepostory.findAll();
    }
    
    private String upload_folder = "src//main//resources//static//fotos/";
    public void saveMultipleFiles(List<MultipartFile> files) throws IOException {
        for(MultipartFile file: files){
            if(file.isEmpty()) continue;
            byte[] bytes = file.getBytes();
          
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path, bytes);
           
        }
        
    }
    
    public Foto guardar(Foto foto){
    return fotoRepostory.save(foto);
    }
    
   
   

}
