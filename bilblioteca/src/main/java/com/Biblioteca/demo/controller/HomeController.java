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

@Controller
public class HomeController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String home(Model model) {
        // Obtener algunos libros para mostrar en la página de inicio
        List<Libro> librosDestacados = libroService.findDisponibles();
        
        // Si hay libros, tomar el primero como "nuevo libro destacado"
        if (!librosDestacados.isEmpty()) {
            model.addAttribute("nuevoLibro", librosDestacados.get(0));
        }
        
        model.addAttribute("titulo", "Biblioteca Digital");
        model.addAttribute("librosDestacados", librosDestacados);
        
        return "index";
    }
}