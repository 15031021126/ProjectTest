package com.lohootech.modules.service;

import com.lohootech.modules.dao.UserMapper;
import com.lohootech.modules.entity.CompanyCount;
import com.lohootech.modules.entity.PersonCount;
import com.lohootech.modules.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    public List<User> login(User user) {
        return userMapper.login(user);
    }
    /**
     * 查询全部
     *
     * @return
     */
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    /**
     * 统计有多少人
     * @return
     */
    public List<PersonCount>    getPersonCount() {
        return userMapper.getPersonCount();
    }

    /**
     * gsnum
     * @return
     */
    public  List<CompanyCount> getCompanyCount() {
        return userMapper.getCompanyCount();
    }
}
