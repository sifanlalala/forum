package sifan.forum.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sifan.forum.model.RegUser;

@Mapper
public interface RegUserMapper {
    @Select("select * from user where token=(#{token})")
    Integer select(RegUser regUser);
}
