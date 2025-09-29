package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.model.HistoricoMoto;
import br.com.fiap.motoconnect.challenge.service.HistoricoMotoService;
import br.com.fiap.motoconnect.challenge.service.MotoService;
import br.com.fiap.motoconnect.challenge.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/historico")
public class HistoricoMotoController {

    private final HistoricoMotoService service;
    private final MotoService motoService;


    public HistoricoMotoController(HistoricoMotoService service, MotoService motoService) {
        this.service = service;
        this.motoService = motoService;
    }

    // Listar todos os registros
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("historicos", service.listarTodos());
        return "historico/list";
    }

    // Formulário para novo registro
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("historico", new HistoricoMoto());
        model.addAttribute("motos", motoService.listarTodos());

        return "historico/form";
    }

    // Salvar novo registro
    @PostMapping
    public String salvar(@Valid @ModelAttribute HistoricoMoto historico, BindingResult result) {
        if (result.hasErrors()) return "historico/form";
        service.salvar(historico);
        return "redirect:/historico";
    }

    // Formulário para editar registro existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        HistoricoMoto historico = service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("historico", historico);
        model.addAttribute("motos", motoService.listarTodos());
        return "historico/form";
    }

    // Atualizar registro existente
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute HistoricoMoto historico, BindingResult result) {
        if (result.hasErrors()) return "historico/form";
        historico.setId(id);
        service.salvar(historico);
        return "redirect:/historico";
    }

    // Deletar registro
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/historico";
    }
}
