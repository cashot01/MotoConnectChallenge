package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.model.Usuario;
import br.com.fiap.motoconnect.challenge.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        return "usuarios/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) return "usuarios/form";
        service.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Usuario usuario = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) return "usuarios/form";
        usuario.setId(id);
        service.salvar(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/usuarios";
    }
}
