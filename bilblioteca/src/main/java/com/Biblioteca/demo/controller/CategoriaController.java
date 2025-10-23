package com.Biblioteca.demo.controller;

/**
 *
 * @author darry
 */
import com.Biblioteca.demo.domain.Categoria;
import com.Biblioteca.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listar todas las categorías - CORREGIDO
    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("titulo", "Gestión de Categorías");
        return "categoria/listar"; // ← Cambiado de "categorias/listar" a "categoria/listar"
    }

    // Mostrar formulario para nueva categoría - CORREGIDO
    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo", "Nueva Categoría");
        return "categoria/formulario"; // ← Cambiado de "categorias/formulario" a "categoria/formulario"
    }

    // Guardar nueva categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria, RedirectAttributes redirect) {
        categoriaService.save(categoria);
        redirect.addFlashAttribute("mensaje", "Categoría guardada exitosamente!");
        return "redirect:/categorias";
    }

    // Mostrar formulario para editar categoría - CORREGIDO
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de categoría inválido: " + id));

        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo", "Editar Categoría");

        return "categoria/formulario"; // ← Cambiado de "categorias/formulario" a "categoria/formulario"
    }

    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id, RedirectAttributes redirect) {
        categoriaService.deleteById(id);
        redirect.addFlashAttribute("mensaje", "Categoría eliminada exitosamente!");
        return "redirect:/categorias";
    }
}
