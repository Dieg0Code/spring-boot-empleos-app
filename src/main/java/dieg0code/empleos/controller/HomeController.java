package dieg0code.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarHome(Model model) {
        /*
        model.addAttribute("mensaje", "Bienvenido a Empleos App");
        model.addAttribute("fecha", new Date());
        */
        String nombre = "Auxiliar de Contabilidad";
        Date fechaPub = new Date();
        double salario = 9000.0;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";
    }

}
