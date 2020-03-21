package sifan.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sifan.forum.dto.NotificationDTO;
import sifan.forum.dto.PaginationDTO;
import sifan.forum.enums.NotificationTypeEnum;
import sifan.forum.mapper.NotificationMapper;
import sifan.forum.model.User;
import sifan.forum.service.NotificationService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
            @PathVariable(name = "id") Long id){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return  "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
        return "redirect:/question/"+notificationDTO.getOuterId();
        }else{
            return  "redirect:/";
        }
    }
}
