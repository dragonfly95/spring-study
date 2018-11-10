package com.tistory.pentode;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tistory.pentode.service.BoardService;
import com.tistory.pentode.vo.TransferVO;
import com.tistory.pentode.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/boardList.do")
	public String boardList(Model model) throws Exception {
		List<BoardVO> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "boardList";
	}
	
	@RequestMapping(value = "/mapProcedureList.do")
	public String mapProcedureList(Model model) throws Exception {
		Map<String, Object> map = boardService.mapProcedureList();
		model.addAttribute("list", map.get("resultList"));
		model.addAttribute("name", map.get("name"));
		return "mapList";
	}

	@RequestMapping(value = "/procedureList.do")
	public String procedureList(Model model) throws Exception {
		TransferVO container = boardService.procedureList();
		model.addAttribute("list", container.getResultList());
		model.addAttribute("name", container.getName());
		return "procList";
	}
	
	@RequestMapping(value = "/anonymousBlockList.do")
	public String anonymousBlockList(Model model) throws Exception {
		TransferVO container = boardService.anonymousBlockList();
		model.addAttribute("list", container.getResultList());
		model.addAttribute("name", container.getName());
		return "procList";
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		return "home";
	}
}
