package huskysir.controller;

import huskysir.entity.User;
import huskysir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


/**
 * 表现层 用户登录
 */
@Controller
@RequestMapping(value = "/Login")
public class LoginController {

    /**
     * 用户service对象
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 返回登录页面（退出登录）
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/LoginOut")
    public String LoginOut(HttpSession httpSession) {
        httpSession.invalidate();    // 获取session信息，使session信息失效，直接返回登录界面，并连接跳转
        return "Login/login";        //返回登录页面
    }

    /**
     * 返回登录页面（注册成功）
     * @return
     */
    @RequestMapping(value = "/LoginPage")
    public String ReturnLogin() {
        return "Login/login";
    }

    /**
     * 用户登录
     * @param user_name
     * @param user_password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/User",method = {RequestMethod.POST})
    public String UserLogin(String user_name,String user_password,Model model,HttpServletRequest request) {

        //根据用户名查询用户信息
        User database_user = userService.findUserByName(user_name);

        //如果用户名与用户密码输入正确，则需要保存用户的编号和昵称信息
        if (database_user != null) {
            //用户编号
            Integer database_user_id = database_user.getUser_id();
            //用户名
            String database_user_name = database_user.getUser_name();
            //用户密码
            String database_user_password = database_user.getUser_password();
            //用户状态
            Integer database_user_status = database_user.getUser_status();

            //用户名与用户密码与数据库内匹配
            if (user_name.equals(database_user_name) && user_password.equals(database_user_password) && database_user_status == 1) {
                HttpSession httpSession = request.getSession(true); //存在session则使用，不存在则新创建
                httpSession.setAttribute("login_user_id", database_user_id);    //将数据库返回的用户编号存入session中
                String database_user_nickname = database_user.getUser_nickname();
                httpSession.setAttribute("login_user_nickname", database_user_nickname);  //将数据库返回的用户昵称存入session中
                Date date = new Date();
                database_user.setUser_last_login_time(date);
                userService.updateUser(database_user);      //更新用户最近一次登录时间
                return "User/user";
            } else if(user_name.equals(database_user_name) && user_password.equals(database_user_password)){
                String msg = "用户被禁用";
                model.addAttribute("msg",msg);
                return "Login/loginFail";
            } else {
                String msg = "用户密码错误";
                model.addAttribute("msg",msg);
                return "Login/loginFail";
            }
        } else {
            String msg = "用户不存在";
            model.addAttribute("msg",msg);
            return "Login/loginFail";
        }
    }

    /**
     * 管理员登录 该功能暂未开放
     * @param user_name
     * @param user_password
     * @param model
     * @return
     */
    /*@RequestMapping(value = "/Administrator",method = {RequestMethod.POST})
    public String AdministratorLogin(String user_name, String user_password,Model model) {

        //根据用户名查询用户信息
        User user = loginService.findUserByName(user_name);
        if (user != null) {
            //用户名
            String return_user_name = user.getUser_name();
            //用户密码
            String return_user_password = user.getUser_password();
            //用户状态
            Integer return_user_status = user.getUser_status();

            //用户名与用户密码与数据库内匹配
            if (user_name.equals(return_user_name)&&user_password.equals(return_user_password)&&return_user_status == 0) {
                return "Administrator/administrator";
            } else {
                String msg = "密码错误";
                model.addAttribute("msg",msg);
                return "Login/loginFail";
            }
        } else {
            String msg = "用户名错误";
            model.addAttribute("msg",msg);
            return "Login/loginFail";
        }
    }*/

}
