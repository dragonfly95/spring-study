package com.tistory.pentode;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.pentode.service.ChagyebuService;
import com.tistory.pentode.vo.ChagyebuVO;

@Controller
public class HomeController {
	@Resource(name = "boardService")
	private ChagyebuService chagyebuService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 메인화면을 생성합니다.
	 * @return
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	/**
	 * POST 방식으로 값을 전달하는 방법 입니다.
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchPost.do", method = RequestMethod.POST)
	public @ResponseBody 
	  Map<String, Object>  searchPost(@RequestBody ChagyebuVO vo) throws Exception {
		  LOGGER.info(vo.toString());
	
		return chagyebuService.selectChagyebuList(vo);
	}
	
	/**
	 * GET 방식으로 값을 전달하는 방법 입니다.
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchGet.do", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> searchGet(ChagyebuVO vo) throws Exception {
		LOGGER.info(vo.toString());
	
		return chagyebuService.selectChagyebuList(vo);
	}
}
