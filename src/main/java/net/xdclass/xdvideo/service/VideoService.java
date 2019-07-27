package net.xdclass.xdvideo.service;

import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : dk
 * @date : 2019/7/27 15:38
 * @description :
 */
@Service
public interface VideoService {
    List<Video> findAll();

    Video findById(int id);

    int update(Video Video);

    int delete(int id);

    int save(Video video);
}
