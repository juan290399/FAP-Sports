package com.olimpiadas_fap.integrador.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
@ControllerAdvice
public class NavegadorController {

    @GetMapping("/inicio")
    public String inicio() {
        return "index";
    }

    @GetMapping("/conocenos")
    public String conocenos() {
        return "about_us";
    }

    @GetMapping("/contactanos")
    public String contactanos() {
        return "contact_form";
    }

    @GetMapping("/reservaciones")
    public String reservaciones() {
        return "reservation_form";
    }

    @GetMapping("/register")
    public String registro() {
        return "register_form";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/inicio";
    }
        // Simulación de Login
    @GetMapping("/simularLogin")
    public String simularLogin(HttpSession session) {
        Map<String, String> usuarioFake = new HashMap<>();
        usuarioFake.put("nombre", "Juan Pérez");
        session.setAttribute("usuario", usuarioFake);
        return "redirect:/inicio";
    }
    @GetMapping("signin")
    public String login() {
        return "login_form";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(Model model) {
        model.addAttribute("error", "Página no encontrada");
        return "404";
    }
}
