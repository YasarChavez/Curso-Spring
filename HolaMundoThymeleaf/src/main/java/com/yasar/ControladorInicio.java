package com.yasar;

import com.yasar.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Mensaje con thymeleaf";
        Persona persona = new Persona();
        persona.setNombre("Yasar");
        persona.setApellido("Chavez");
        persona.setEmail("yasar@gmail.com");
        persona.setTelefono("11223344");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Perez");
        persona2.setEmail("juan@gmail.com");
        persona2.setTelefono("11559977");
        
//        List<Persona> personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);
// OTRA FORMA
        var personas = Arrays.asList(persona,persona2);
        
        
        log.info("Ejecutando el controlador SpringMVC");
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo",saludo);
        model.addAttribute("persona",persona);
        model.addAttribute("personas",personas);
        return "index";
    }
}
