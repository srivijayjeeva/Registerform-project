package com.example.registerapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.*;

@Controller
public class RegisterController {

    @GetMapping("/")
    public String home() {
        return "redirect:/register.html";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://database-2.cwdmmuiqazo8.us-east-1.rds.amazonaws.com/registerdb",
                "admin",
                "srivijay"
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password) VALUES(?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            ps.close();
            con.close();

            return "Registration Successful";

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
