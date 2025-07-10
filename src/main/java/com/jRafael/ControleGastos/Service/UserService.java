package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);

    }

    public List<User> fidAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Transactional
    public void delete(String email){
        userRepository.deleteByEmail(email);
    }

}
