package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.service.UsuarioService;
import br.com.fiap.motoconnect.challenge.service.MotoService;
import br.com.fiap.motoconnect.challenge.service.HistoricoMotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final UsuarioService usuarioService;
    private final MotoService motoService;
    private final HistoricoMotoService historicoService;

    public DashboardController(UsuarioService usuarioService, MotoService motoService,
                               HistoricoMotoService historicoService) {
        this.usuarioService = usuarioService;
        this.motoService = motoService;
        this.historicoService = historicoService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalUsuarios", usuarioService.listarTodos().size());
        model.addAttribute("totalMotos", motoService.listarTodos().size());
        model.addAttribute("totalHistorico", historicoService.listarTodos().size());
        return "index";
    }
}
