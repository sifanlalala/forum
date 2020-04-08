package sifan.forum.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sifan.forum.dto.RegUserDTO;
import sifan.forum.mapper.RegUserMapper;
import sifan.forum.model.RegUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {
    @GetMapping("/login")
    public String regist() {
        return "login";
    }

    @Autowired
    private RegistController registController;
    @Autowired
    private RegUserMapper regUserMapper;
    @ResponseBody
    @RequestMapping(value = "/loginapi", method = RequestMethod.POST)
    public Object loginapi(@RequestParam(name = "phone")String phone,
                           @RequestParam(name = "passwd")String passwd,
                           HttpServletResponse response){
        String token = registController.getMD5(phone, 32);
        RegUser regUser = new RegUser();
        regUser.setToken(token);
        Integer reguser = regUserMapper.select(regUser);
        if (reguser != null) {
            response.addCookie(new Cookie("token", token));
            return RegUserDTO.okOf(token);
        } else {
            log.error("reg error,{}", reguser);
            //登录失败，重新登录
            return RegUserDTO.errorOf(2002, "该用户不存在");
        }
    }

}
