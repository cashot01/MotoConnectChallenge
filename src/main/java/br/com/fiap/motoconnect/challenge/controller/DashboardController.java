package br.com.fiap.motoconnect.challenge.controller;

import br.com.fiap.motoconnect.challenge.service.RfidService;
import br.com.fiap.motoconnect.challenge.service.UsuarioService;
import br.com.fiap.motoconnect.challenge.service.MotoService;
import br.com.fiap.motoconnect.challenge.service.HistoricoMotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final MotoService motoService;
    private final HistoricoMotoService historicoService;
    private final RfidService rfidService;

    public DashboardController(MotoService motoService,
                               HistoricoMotoService historicoService,
                               RfidService rfidService) {

        this.motoService = motoService;
        this.historicoService = historicoService;
        this.rfidService= rfidService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("totalMotos", motoService.listarTodos().size());
        model.addAttribute("totalHistorico", historicoService.listarTodos().size());
        model.addAttribute("totalRfid", rfidService.listarTodos().size());
        return "index";
    }
}
