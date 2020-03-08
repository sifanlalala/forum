package sifan.forum.dto;

import lombok.Data;
import sifan.forum.model.User;

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
