package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VideoMapper;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XdvideoApplicationTests {

	@Autowired
	VideoMapper videoMapper;
	@Test
	public void contextLoads() {
		Video video= new Video();
		video.setTitle("1");
		videoMapper.save(video);
	}

	@Test
	public  void  testJwt()
	{
		User user =new User();
		user.setId(1);
		user.setHeadImg("www.ssss");
		user.setName("user");
		String token = JwtUtils.geneJsonWebToken(user);

		System.out.println(token);
	}
	@Test
	public  void  testCheck()
	{
		String token="1eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjEsIm5hbWUiOiJ1c2VyIiwiaW1nIjoid3d3LnNzc3MiLCJpYXQiOjE1NjQzODQwNjgsImV4cCI6MTU2NDk4ODg2OH0.VnB3omkGWh-Mnrhl_raUQ7rFBtLuMIc66ohJINLV5d4";
		Claims claims= JwtUtils.checkJWT(token);
		if (claims!=null)
		{
			String name=(String) claims.get("name");
			String img=(String) claims.get("img");
			int id=(Integer) claims.get("id");
			System.out.println(name);
			System.out.println(img);
			System.out.println(id);
		}
		else
		{
			System.out.println("非法token");
		}

	}




}
