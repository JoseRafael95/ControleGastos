package com.jRafael.ControleGastos.Service;

import com.jRafael.ControleGastos.Dto.UserDto;
import com.jRafael.ControleGastos.Entity.User;
import com.jRafael.ControleGastos.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setId(1L);
        user.setName("nome");
        user.setEmail("nome@email.com");

        userDto = new UserDto(user);
    }

    @Test
    void save() {
        // Arrange
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserDto result = userService.save(userDto);

        //Assert
        assertNotNull(result);

    }

    @Test
    void fidAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<User> userPage = new PageImpl<>(Collections.singletonList(user), pageable, 1);
        doReturn(userPage).when(userRepository).findAll(pageable);

        Page<UserDto> result = userService.fidAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(user.getName(), result.getContent().get(0).getName());
        verify(userRepository, times(1)).findAll(pageable);
    }

    @Test
    void findByEmail() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        User result = userRepository.findByEmail(userDto.getEmail());

        assertNotNull(result);
        assertEquals(user, result);

    }

    @Test
    void update() {
        UserDto userUpdate = new UserDto(
                1L,
                "nome Atualizado",
                "nomeAtualizado@email.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto result = userService.update("nome@email.com",userUpdate);

        assertNotNull(result);
        assertEquals(userUpdate.getName(), result.getName());
        assertEquals(userUpdate.getEmail(), result.getEmail());

    }


    @Test
    void delete() {
        doNothing().when(userRepository).deleteByEmail(user.getEmail());

        userService.delete(user.getEmail());

        verify(userRepository, times(1)).deleteByEmail(user.getEmail());
    }
}