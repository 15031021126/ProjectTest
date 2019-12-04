package com.lohootech.modules.dao;

import com.lohootech.annotation.MyBatisDao;
import com.lohootech.modules.entity.CompanyCount;
import com.lohootech.modules.entity.PersonCount;
import com.lohootech.modules.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
@MyBatisDao
public interface UserMapper {
    /**
     * 登录
     * @param user
     * @return
     */
    List<User> login(User user);

    /**
     * 查询全部
     * @return
     */
    List<User> selectAll();

    /**
     * 查询男女比例
     * @return
     */
    List<PersonCount>   getPersonCount();

    /**、	统计每个公司有多少人员
     * @return
     */
    List<CompanyCount>  getCompanyCount();

}
