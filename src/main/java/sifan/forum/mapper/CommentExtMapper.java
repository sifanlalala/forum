package sifan.forum.mapper;

import sifan.forum.model.Comment;
import sifan.forum.model.Question;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
