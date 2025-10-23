package com.Biblioteca.demo.controller;

/**
 *
 * @author darry
 */

import com.Biblioteca.demo.domain.Queja;
import com.Biblioteca.demo.domain.TipoQueja;
import com.Biblioteca.demo.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    // Mostrar formulario para nueva queja/sugerencia - CORREGIDO
    @GetMapping("/nueva")
    public String mostrarFormularioQueja(Model model) {
        Queja queja = new Queja();
        model.addAttribute("queja", queja);
        model.addAttribute("tiposQueja", TipoQueja.values());
        model.addAttribute("titulo", "Quejas y Sugerencias");
        return "quejas/formulario"; // ← Este está correcto
    }

    // Procesar queja/sugerencia
    @PostMapping("/procesar")
    public String procesarQueja(@ModelAttribute Queja queja, RedirectAttributes redirect) {
        quejaService.save(queja);
        redirect.addFlashAttribute("mensaje", "¡Gracias! Tu " + queja.getTipo().toString().toLowerCase() + " ha sido enviada.");
        return "redirect:/quejas/nueva";
    }

    // Listar quejas (para administración) - CORREGIDO
    @GetMapping
    public String listarQuejas(Model model) {
        List<Queja> quejas = quejaService.findAll();
        model.addAttribute("quejas", quejas);
        model.addAttribute("titulo", "Gestión de Quejas y Sugerencias");
        return "quejas/listar"; // ← Si tienes esta vista, sino puedes comentarla
    }

    // Marcar queja como tratada
    @GetMapping("/tratar/{id}")
    public String marcarComoTratada(@PathVariable Long id, RedirectAttributes redirect) {
        quejaService.marcarComoTratada(id);
        redirect.addFlashAttribute("mensaje", "Queja marcada como tratada!");
        return "redirect:/quejas";
    }
}