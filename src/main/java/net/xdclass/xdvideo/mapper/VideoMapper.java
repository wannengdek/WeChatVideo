package net.xdclass.xdvideo.mapper;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : dk
 * @date : 2019/7/27 16:02
 * @description :
 */

@Mapper
public interface VideoMapper {

//    @Select("select * from video")
//    List<Video> findAll();

    @Select("select * from video")
      @Results({
                @Result(column = "cover_img",property =
					"coverImg"),
                @Result(column = "create_time",property =
                            "createTime")
      })
    //字段映射
    List<Video> findAll();
    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);

    @Update("UPDATE video SET title=#{title} WHERE id =#{id}")
   // @UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);
    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
            "`cover_img`, `view_num`, `price`, `create_time`," +
            " `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
            ",#{online},#{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    // 技巧：保存对象，获取数据库自增id
    int save(Video video);
}
