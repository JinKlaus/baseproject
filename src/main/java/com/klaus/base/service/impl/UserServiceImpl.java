package com.klaus.base.service.impl;

import com.wfq.demo_sb.entity.UserEntity;
import com.wfq.demo_sb.repository.UserRepository;
import com.wfq.demo_sb.service.UserService;
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
