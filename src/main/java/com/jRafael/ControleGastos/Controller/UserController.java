package com.jRafael.ControleGastos.Controller;

import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.fidAll());
    }

    @GetMapping
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email){
        userService.delete(email);
    }


}
