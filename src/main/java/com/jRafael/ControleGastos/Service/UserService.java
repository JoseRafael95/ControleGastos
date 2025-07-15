package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Dto.UserDto;
import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.UserRepository;
import com.jRafael.ControleGastos.Service.exceptions.UserNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public UserDto save(User user){
        User saveUser = userRepository.save(user);
        return new UserDto(saveUser);
    }

    public Page<UserDto> fidAll(Pageable pageable){
        Page<User> listUser = userRepository.findAll(pageable);
        return listUser.map(x-> new UserDto(x));
    }

    public UserDto findByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserNotFound("Usuário ou email não encotrado");
        }
        return new UserDto(user);
    }
    @Transactional
    public void delete(String email){
        userRepository.deleteByEmail(email);
    }

}
