package com.jRafael.ControleGastos.Controller;

import com.jRafael.ControleGastos.Dto.UserDto;
import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Service.UserService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(userService.fidAll(pageable));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping("{user}")
    public  ResponseEntity<UserDto> update(@PathVariable String user,@Valid @RequestBody UserDto newUser){
        return ResponseEntity.ok(userService.update(user, newUser));
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email){
        userService.delete(email);
    }


}
