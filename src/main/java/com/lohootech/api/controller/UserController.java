package com.lohootech.api.controller;

import com.lohootech.modules.entity.PersonCount;
import com.lohootech.modules.entity.User;
import com.lohootech.modules.entity.base.ServerResponse;
import com.lohootech.modules.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public ServerResponse login(@RequestBody String str) {
        User user =new User();
       // user.setPhone(phone);
        //user.setPassword(password);
        try {
            JSONObject jsonObject = new JSONObject(str);
            String phone = jsonObject.getString("phone");
            String password = jsonObject.getString("password");
            System.out.print(phone + password);
            user = new User();
            user.setPhone(phone);
            user.setPassword(password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(user+"\n"+userService.login(user));
        return (userService.login(user) != null && userService.login(user).size() > 0) ?
                ServerResponse.createBySuccess("登录成功", "用户:" + user)
                : ServerResponse.createByErrorCodeMessage
                (403, "登录失败,请检查账号或密码");
    }


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    @CrossOrigin
    public ServerResponse getUserList() {
        System.out.println(userService.selectAll());
        List<User> list = new ArrayList<>();
        list= userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus()!=null&&list.get(i).getStatus().equals("0")) {
                list.get(i).setStatus("离职");
            } else if(list.get(i).getStatus()!=null&&list.get(i).getStatus().equals("1")){
                list.get(i).setStatus("在职");
            }
        }
        return ServerResponse.createBySuccess("查询成功",list);
    }

    /**
     * 统计男女人数
     * @return
     */
    @RequestMapping("/getPersonCount")
    @ResponseBody
    @CrossOrigin
    public ServerResponse getPersonCount(){
        List<PersonCount> personCount = userService.getPersonCount();
        for (int i = 0; i < personCount.size(); i++) {
            double manCount = personCount.get(i).getMan_count();
            double womanCount = personCount.get(i).getWoman_count();
            double total = manCount + womanCount;
            personCount.get(i).setMan_count((int) ((manCount/total)*100));
            personCount.get(i).setWoman_count((int) ((womanCount/total)*100));
        }
        return ServerResponse.createBySuccess("查询成功",personCount);
    }

    /**
     * 公司人数
     * @return
     */
    @RequestMapping("/getCompanyCount")
    @ResponseBody
    @CrossOrigin
    public ServerResponse getCompanyCount() {
        return ServerResponse.createBySuccess("查询成功", userService.getCompanyCount());
    }
}
