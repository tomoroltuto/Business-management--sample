package com.example.businessmanagement.repository.user;


import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRepository {


  @Select("SELECT id,company_name, user_name FROM users WHERE id = #{userId}")
  Optional<UserRecord> select(long userId);

  @Select("SELECT * from users")
  List<UserRecord> selectList();

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("INSERT INTO users (company_name, user_name) values (#{companyname}, #{username})")
  void insert(UserRecord record);

  @Update("UPDATE users SET company_name = #{companyname}, user_name = #{username} WHERE id = #{id}")
  void update(UserRecord record);

  @Delete("DELETE FROM users WHERE id = #{id}")
  void delete(Long userId);
}
