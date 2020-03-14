package sifan.forum.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import sifan.forum.model.Question;
import sifan.forum.model.User;

import java.util.List;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer ViewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}

