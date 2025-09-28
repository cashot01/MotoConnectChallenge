package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.model.Moto;
import br.com.fiap.motoconnect.challenge.service.MotoService;
import br.com.fiap.motoconnect.challenge.service.RfidService;
import br.com.fiap.motoconnect.challenge.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/motos")
public class MotoController {
    private final MotoService service;
    private final RfidService rfidService;
    private final UsuarioService usuarioService;

    public MotoController(MotoService service, RfidService rfidService, UsuarioService usuarioService) {
        this.service = service;
        this.rfidService = rfidService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", service.listarTodos());
        return "motos/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("rfids", rfidService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "motos/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Moto moto, BindingResult result) {
        if (result.hasErrors()) return "motos/form";
        service.salvar(moto);
        return "redirect:/motos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Moto moto = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("moto", moto);
        model.addAttribute("rfids", rfidService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "motos/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute Moto moto, BindingResult result) {
        if (result.hasErrors()) return "motos/form";
        moto.setId(id);
        service.salvar(moto);
        return "redirect:/motos";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/motos";
    }
}
