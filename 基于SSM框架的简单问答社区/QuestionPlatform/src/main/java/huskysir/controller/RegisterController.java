package huskysir.controller;

import huskysir.entity.User;
import huskysir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 表现层 用户注册
 */
@Controller
@RequestMapping(value = "/Register")
public class RegisterController {

    /**
     * 用户service对象
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 进入注册页面
     * @return
     */
    @RequestMapping(value = "/RegisterPage")
    public String Register() {
        return "Login/register";  //进入注册界面
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/SaveUser")
    public String SaveUser(User user) {

        //根据用户名查询数据库内的用户
        User database_user = userService.findUserByName(user.getUser_name());
        //如果存在用户，说明该用户名已经被注册
        if (database_user != null) {
            return "Login/registerFail";                        //返回注册失败页面
        } else {
            //用户名、用户昵称、用户性别、用户邮箱、用户密码已经由框架封装进user内,用户头像默认为空
            Date date = new Date();
            user.setUser_register_time(date);                   //用户注册时间
            user.setUser_last_login_time(date);                 //用户最近一次登录时间
            //用户最近一次登录的ip地址先设置为空
            user.setUser_last_login_ip(null);
            user.setUser_status(1);                             //用户状态

            userService.saveUser(user);
            return "Login/registerSuccess";                     //返回注册成功页面
        }
    }

}
