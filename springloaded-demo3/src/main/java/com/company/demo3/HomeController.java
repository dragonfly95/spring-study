package com.company.demo3;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public BoardService boardService ;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/board/list.do")
	public String list(Model model){
		int boardCount = boardService.boardCount();
		List<BoardVO> getlist = boardService.getlist();

		logger.debug("boardCount", boardCount);
		logger.debug("getlist", getlist);

		System.out.println(boardCount);

		model.addAttribute("boardCount",boardCount);
		model.addAttribute("getlist",getlist);

		return "board/list";
	}


	// 등록
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String writeForm(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		System.out.print("id::" + id);
	    return "board/write";
    }


	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String writeDO(HttpServletRequest request,
												@ModelAttribute BoardVO boardVO ,
												Model model){

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		System.out.println("subject::" + subject);
		System.out.println("content::" + content);


		logger.info("boardVO", boardVO.toString());
		System.out.println(boardVO.toString());

	  return "redirect:list.do";
//		return null;
	}

    //----------------------------------------------------//
	// 상세
	@RequestMapping(value="/board/detail.do")
	public String detilDO(BoardVO boardVO,Model model){
		BoardVO boardVO1 = boardService.doDetail(boardVO.getId());
		model.addAttribute("boardVO1",boardVO1);
		return "board/detail";
	}


	//------------------------------------------------------//

	// 상세에서 수정하는거
	@RequestMapping(value = "/board/modify.do")
	public String modifyDO(BoardVO boardVO , Model model){
		BoardVO boardVO1 = boardService.doDetail(boardVO.getId());
		model.addAttribute("boardVO1",boardVO1);
		return "board/modify";
	}



	@RequestMapping(value="/board/detail.do", method = RequestMethod.POST)
	public String modifyDo(BoardVO boardVO , Model model){
		int affected = boardService.upDate(boardVO);

		BoardVO boardVO1 = boardService.doDetail(boardVO.getId());
		model.addAttribute("boardVO1",boardVO1);
		return "board/detail" ;

	}

	// 삭제하는 거
	@RequestMapping(value="/board/delete.do", method = RequestMethod.POST)
	public String deleteDo(BoardVO boardVO){
		boardService.deleteDo(boardVO.getId());
		return "board/list";
	}
}
