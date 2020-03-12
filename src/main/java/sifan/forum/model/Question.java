package sifan.forum.model;

import lombok.Data;
@Data
public class Question {
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
}
