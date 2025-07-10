package com.jRafael.ControleGastos.Repository;

import com.jRafael.ControleGastos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    void deleteByEmail(String email);
}
