package sifan.forum.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sifan.forum.dto.RegUserDTO;
import sifan.forum.mapper.RegUserMapper;
import sifan.forum.model.RegUser;
import sifan.forum.model.User;
import sifan.forum.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Controller
public class RegistController {
    @GetMapping("/regist")
    public String regist() {
        return "register";
    }

    @Autowired
    private RegUserMapper regUserMapper;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/userregist", method = RequestMethod.POST)
    public Object userregist(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "phonenumber") String phonenumber,
            @RequestParam(name = "password") String password,
            HttpServletResponse response) {
        String token = getMD5(phonenumber, 32);
        RegUser regUser = new RegUser();
        regUser.setToken(token);
        Integer reguser = regUserMapper.select(regUser);
        if (reguser == null) {
            User user = new User();
            user.setAccountId(phonenumber);
            user.setToken(token);
            user.setName(name);
            user.setBio(password);
            user.setAvatarUrl("https://dwz.cn/jr2lAZ8d");
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", token));
            return RegUserDTO.okOf(token);
        } else {
            log.error("注册失败该用户已存在,{}", reguser);
            //登录失败，重新登录
            return RegUserDTO.errorOf(2002, "该用户已存在");
        }
    }

    //md5加密
    public static String getMD5(String plainText, int length) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
            md.update(plainText.getBytes());//此处传入要加密的byte类型值
            byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值

            /*
               下边的运算就是自己添加的一些二次小加密，记住这个千万不能弄错乱，
                   否则在解密的时候，你会发现值不对的（举例：在注册的时候加密方式是一种，
                在我们登录的时候是不是还需要加密它的密码然后和数据库的进行比对，但是
            最后我们发现，明明密码对啊，就是打不到预期效果，这时候你就要想一下，你是否
             有改动前后的加密方式）
            */
            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
            }
            return sb.toString().substring(0, length);//从下标0开始，length目的是截取多少长度的值
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
