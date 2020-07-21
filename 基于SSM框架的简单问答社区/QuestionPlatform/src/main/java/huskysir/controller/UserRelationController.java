package huskysir.controller;

import huskysir.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * 表现层 用户关系相关 (关注用户、被用户关注、关注问题、赞同回答)
 */
@Controller
@RequestMapping("/UserRelation")
public class UserRelationController {

    /**
     * 用户关系service对象
     */
    @Autowired
    @Qualifier("userRelationService")
    private UserRelationService userRelationService;

    /**
     * 新增某用户关注某用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/SaveUserFollowUser",method = {RequestMethod.POST})
    public @ResponseBody Boolean SaveUserFollowUser(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_user_id = Integer.parseInt(map.get("to_user_id"));
        //是否新增成功
        //该项可以增加发起者用户和接受者用户是否是同一用户的判断，即比较from_user_id与to_user_id是否相等，如果相等则关注失败
        //通过返回Integer类型而非Boolean类型的做判断 本程序并未增加这项判断
        Boolean flag = userRelationService.saveUserFollowUser(from_user_id,to_user_id);

        return flag;

    }

    /**
     * 删除某用户关注某用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/DeleteUserFollowUser",method = {RequestMethod.POST})
    public @ResponseBody Boolean DeleteUserFollowUser(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_user_id = Integer.parseInt(map.get("to_user_id"));
        //是否删除成功
        Boolean flag = userRelationService.deleteUserFollowUser(from_user_id,to_user_id);

        return flag;

    }

    /**
     * 新增某用户关注某问题
     * @param map
     * @return
     */
    @RequestMapping(value = "/SaveUserFollowQuestion",method = {RequestMethod.POST})
    public @ResponseBody Boolean SaveUserFollowQuestion(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_question_id = Integer.parseInt(map.get("to_question_id"));


        //是否新增成功
        Boolean flag = userRelationService.saveUserFollowQuestion(from_user_id,to_question_id);

        return flag;

    }

    /**
     * 删除某用户关注某问题
     * @param map
     * @return
     */
    @RequestMapping(value = "/DeleteUserFollowQuestion",method = {RequestMethod.POST})
    public @ResponseBody Boolean DeleteUserFollowQuestion(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_question_id = Integer.parseInt(map.get("to_question_id"));
        //是否删除成功
        Boolean flag = userRelationService.deleteUserFollowQuestion(from_user_id,to_question_id);

        return flag;

    }

    /**
     * 新增某用户赞同某回答
     * @param map
     * @return
     */
    @RequestMapping(value = "/SaveUserSupportAnswer",method = {RequestMethod.POST})
    public @ResponseBody Boolean SaveUserSupportAnswer(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_answer_id = Integer.parseInt(map.get("to_answer_id"));
        //是否新增成功
        Boolean flag = userRelationService.saveUserSupportAnswer(from_user_id,to_answer_id);

        return flag;

    }

    /**
     * 删除某用户赞同某回答
     * @param map
     * @return
     */
    @RequestMapping(value = "/DeleteUserSupportAnswer",method = {RequestMethod.POST})
    public @ResponseBody Boolean DeleteUserSupportAnswer(@RequestBody Map<String,String> map) {

        //关注发出者编号
        Integer from_user_id = Integer.parseInt(map.get("from_user_id"));
        //关注接受者编号
        Integer to_answer_id = Integer.parseInt(map.get("to_answer_id"));
        //是否删除成功
        Boolean flag = userRelationService.deleteUserSupportAnswer(from_user_id,to_answer_id);

        return flag;

    }

}
