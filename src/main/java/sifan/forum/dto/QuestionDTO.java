package sifan.forum.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import sifan.forum.model.Question;
import sifan.forum.model.User;

import java.util.List;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer ViewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}

