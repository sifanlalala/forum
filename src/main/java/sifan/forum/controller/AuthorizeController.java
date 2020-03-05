package sifan.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sifan.forum.dto.AccessTokenDTO;
import sifan.forum.dto.GithubUser;
import sifan.forum.provide.GithubProvider;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("Iv1.be207b81d5e1e4e4")
    private String clientId;
    @Value("f06a6516b99b7185ffb8853a61a02715a3df6de1")
    private String clientSecret;
    @Value("http;//localhost:8887/callback")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("clientId");
        accessTokenDTO.setClient_secret("clientSecret");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("redirectUri");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user != null){
            //登陆成功，写 cookie和 session
            request.getSession().setAttribute("user",user);
            return  "redirect:/";
        }else{
            //登陆失败，重新登录
            return  "redirect:/";
        }
    }
}
