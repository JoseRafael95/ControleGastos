package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);

    }

    public List<User> fidAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void delete(String email){
        userRepository.deleteByEmail(email);
    }

}
