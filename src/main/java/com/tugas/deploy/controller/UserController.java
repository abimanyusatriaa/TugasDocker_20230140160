package com.tugas.deploy.controller;

import com.tugas.deploy.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final Model model = new Model(); // buat objek Model

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        org.springframework.ui.Model uiModel) { // pakai fully qualified name

        if (model.checkLogin(username, password)) {
            return "home";
        } else {
            uiModel.addAttribute("error", "Username atau Password Salah!");
            return "login";
        }
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
    @PostMapping("/submit")
    public String result(@RequestParam String nama,
                         @RequestParam String nim,
                         @RequestParam String jenisKelamin,
                         org.springframework.ui.Model uiModel) {

        com.tugas.deploy.model.Model mhs =
                new com.tugas.deploy.model.Model(nama, nim, jenisKelamin);
        com.tugas.deploy.model.Model.addMahasiswa(mhs);

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(org.springframework.ui.Model uiModel) {
        uiModel.addAttribute("mahasiswaList",
                com.tugas.deploy.model.Model.getMahasiswaList());
        return "home";
    }
}