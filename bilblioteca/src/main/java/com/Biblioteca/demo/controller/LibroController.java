package com.Biblioteca.demo.controller;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Libro;
import com.Biblioteca.demo.domain.Categoria;
import com.Biblioteca.demo.service.LibroService;
import com.Biblioteca.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    // Listar todos los libros - CORREGIDO
    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.findAllWithCategoria();
        model.addAttribute("libros", libros);
        model.addAttribute("titulo", "Gestión de Libros");
        return "libro/listar"; // ← Cambiado de "libros/listar" a "libro/listar"
    }

    // Mostrar formulario para crear nuevo libro - CORREGIDO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Libro libro = new Libro();
        List<Categoria> categorias = categoriaService.findAll();
        
        model.addAttribute("libro", libro);
        model.addAttribute("categorias", categorias);
        model.addAttribute("titulo", "Nuevo Libro");
        
        return "libro/formulario"; // ← Cambiado de "libros/formulario" a "libro/formulario"
    }

    // Guardar nuevo libro
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro, RedirectAttributes redirect) {
        libroService.save(libro);
        redirect.addFlashAttribute("mensaje", "Libro guardado exitosamente!");
        return "redirect:/libros";
    }

    // Mostrar formulario para editar libro - CORREGIDO
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Libro libro = libroService.findByIdWithCategoria(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de libro inválido: " + id));
        List<Categoria> categorias = categoriaService.findAll();
        
        model.addAttribute("libro", libro);
        model.addAttribute("categorias", categorias);
        model.addAttribute("titulo", "Editar Libro");
        
        return "libro/formulario"; // ← Cambiado de "libros/formulario" a "libro/formulario"
    }

    // Eliminar libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect) {
        libroService.deleteById(id);
        redirect.addFlashAttribute("mensaje", "Libro eliminado exitosamente!");
        return "redirect:/libros";
    }
}