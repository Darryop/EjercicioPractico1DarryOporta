package com.Biblioteca.demo.controller;

/**
 *
 * @author darry
 */
import com.Biblioteca.demo.domain.Libro;
import com.Biblioteca.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String home(Model model) {
        // Obtener el libro más reciente para mostrar en la página de inicio
        Optional<Libro> libroReciente = libroService.findLibroMasReciente();
        
        // Obtener algunos libros para mostrar como destacados
        List<Libro> librosDestacados = libroService.findDisponibles();
        
        // Agregar atributos al modelo
        if (libroReciente.isPresent()) {
            model.addAttribute("nuevoLibro", libroReciente.get());
        }
        
        model.addAttribute("titulo", "Biblioteca Digital");
        model.addAttribute("librosDestacados", librosDestacados);
        
        return "index";
    }
}