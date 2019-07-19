package com.klaus.base.service.impl;

import com.klaus.base.entity.UserEntity;
import com.klaus.base.repository.UserRepository;
import com.klaus.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public void addUser(UserEntity user){
        userRepository.save(user);
        //String age = user.getAge().toString();
    }
}
