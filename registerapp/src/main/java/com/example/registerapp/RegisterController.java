package com.example.registerapp;

import org.springframework.web.bind.annotation.*;
import java.sql.*;

@RestController
public class RegisterController {

    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://database-1.cwdmmuiqazo8.us-east-1.rds.amazonaws.com:3306/registerdb",
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