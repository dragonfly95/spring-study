package com.tistory.pentode.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.pentode.service.ChagyebuService;
import com.tistory.pentode.service.dao.ChagyebuDAO;
import com.tistory.pentode.vo.ChagyebuVO;

@Service("boardService")
public class ChagyebuServiceImpl implements ChagyebuService {

	@Autowired
	private ChagyebuDAO chagyebuDAO;
	
	private static final Logger LOGGER = Logger.getLogger(ChagyebuServiceImpl.class);
	
	@Override
	@Transactional
	public Map<String, Object> selectChagyebuList(ChagyebuVO vo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		final int dataPerPage = 10;
		int page = vo.getPage();
		
		int first = page * dataPerPage + 1;
		int last = first + dataPerPage - 1;
		
		vo.setFirst(first);
		vo.setLast(last);
		
		LOGGER.info(vo.toString());
		
		Integer total = chagyebuDAO.selectChagyebuTotal(vo);
		Integer totalPages = (int)Math.ceil(total / dataPerPage);
		
		map.put("total", total);
		map.put("totalPages", totalPages);
		map.put("list", chagyebuDAO.selectChagyebuList(vo));
		
		return map;
	}
}
