package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.model.Rfid;
import br.com.fiap.motoconnect.challenge.service.RfidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/rfids")
public class RfidController {
    private final RfidService service;

    public RfidController(RfidService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("rfids", service.listarTodos());
        return "rfids/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("rfid", new Rfid());
        return "rfids/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Rfid rfid, BindingResult result) {
        if (result.hasErrors()) return "rfids/form";
        service.salvar(rfid);
        return "redirect:/rfids";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Rfid rfid = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("rfid", rfid);
        return "rfids/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute Rfid rfid, BindingResult result) {
        if (result.hasErrors()) return "rfids/form";
        rfid.setId(id);
        service.salvar(rfid);
        return "redirect:/rfids";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/rfids";
    }
}
