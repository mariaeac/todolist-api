package com.meac.todolistapi.services;

import com.meac.todolistapi.entities.User;
import com.meac.todolistapi.entities.UserAuthDTO;
import com.meac.todolistapi.repositories.UserRepository;
import com.meac.todolistapi.security.JWTUtil;
import com.meac.todolistapi.security.TokenDTO;
import com.meac.todolistapi.services.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    public TokenDTO auth(UserAuthDTO userAuthDTO) {

        User user = userRepository.findByEmail(userAuthDTO.getEmail()).orElseThrow(() -> new BusinessException("User not found"));
        if (!passwordEncoder.matches(userAuthDTO.getPassword(), user.getPassword())) {
            throw new BusinessException("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new TokenDTO(token);
    }


}
