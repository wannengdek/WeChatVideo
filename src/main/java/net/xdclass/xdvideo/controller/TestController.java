package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private WeChatConfig weChatConfig;

	@RequestMapping("config")
	public String test()
	{
		System.out.println(weChatConfig.getAppId());
		return "hello";
	}


	@Autowired
	VideoMapper videoMapper;
	@RequestMapping("db")
	public Object testDb()
	{


		return videoMapper.findAll();
	}

}
