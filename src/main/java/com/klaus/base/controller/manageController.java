package com.klaus.base.controller;

import com.klaus.base.entity.UserEntity;
import com.klaus.base.ioPojo.MainInfo;
import com.klaus.base.pojo.User;
import com.klaus.base.repository.UserRepository;
import com.klaus.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class manageController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @RequestMapping("/query.do")
    public MainInfo query(@RequestBody MainInfo mainInfo) {
        List<User> uList = new ArrayList<>();
        MainInfo mi = new MainInfo();
        mi.setIo_type("O");
        String user_id = "";
        String user_name = "";
        String sex = "";
        String age = "";
        if (mainInfo.getUserList().size() > 0) {
            user_id = mainInfo.getUserList().get(0).getUser_id();
            user_name = mainInfo.getUserList().get(0).getUser_name();
            sex = mainInfo.getUserList().get(0).getSex();
            Integer ageCondition = mainInfo.getUserList().get(0).getAge();
            if (null != ageCondition) {
                age = ageCondition.toString();
            }
        }
        String hql = "from UserEntity where 1=1";
        if (!StringUtils.isEmpty(user_id)) {
            hql += " and userId ='" + user_id + "'";
        }
        if (!StringUtils.isEmpty(user_name)) {
            hql += " and userName ='" + user_name + "'";
        }
        if (!StringUtils.isEmpty(sex)) {
            hql += " and sex ='" + sex + "'";
        }
        if (!StringUtils.isEmpty(age)) {
            hql += " and age ='" + age + "'";
        }
        List<UserEntity> userList = userRepository.find(hql);
        if (userList.size() > 0) {
            for (UserEntity user : userList) {
                User u = new User();
                u.setUser_id(user.getUserId());
                u.setUser_name(user.getUserName());
                u.setAge(user.getAge());
                u.setSex(user.getSex());
                uList.add(u);
            }
            mi.setUserList(uList);
            mi.setRtn_code(0000000);
            mi.setRtn_msg("successful find users!");
        } else {
            mi.setRtn_code(0000001);
            mi.setRtn_msg("There is no data!");
        }
        return mi;
    }

    @RequestMapping("/add.do")
    public MainInfo add(@RequestBody MainInfo mainInfo) {
        MainInfo mi = new MainInfo();
        mi.setIo_type("O");
        try {
            if (mainInfo.getUserList().size() > 0) {
                Boolean exitFLg = userRepository.existsById(mainInfo.getUserList().get(0).getUser_id());
                if (!exitFLg) {
                UserEntity user = new UserEntity();
                user.setUserId(mainInfo.getUserList().get(0).getUser_id());
                user.setUserName(mainInfo.getUserList().get(0).getUser_name());
                user.setPassword("123");
                user.setAge(mainInfo.getUserList().get(0).getAge());
                user.setSex(mainInfo.getUserList().get(0).getSex());
                userService.addUser(user);
                mi.setRtn_code(0000000);
                mi.setRtn_msg("successful add users!");

                } else {
                    mi.setRtn_code(0000001);
                    mi.setRtn_msg("fail add users,user already exist");
                }
            } else {
                mi.setRtn_code(0000002);
                mi.setRtn_msg("fail add users,no user add");
            }
        } catch (Exception ex) {
            mi.setRtn_msg(ex.toString());
        }
        return mi;
    }
}
