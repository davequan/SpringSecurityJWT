package com.quan.quan.controller;


import com.quan.quan.model.AuthRequest;
import com.quan.quan.service.UserService;
import com.quan.quan.utili.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(){
        return "welcome to reportGeneration";
    }


















    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
                )
        );
         UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());





         String token = jwtUtility.generateToken(userDetails);
        return token;

    }

}
