package sifan.forum.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sifan.forum.model.Question;
import sifan.forum.model.QuestionExample;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}