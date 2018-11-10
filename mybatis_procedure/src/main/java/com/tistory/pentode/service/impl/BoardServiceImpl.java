package com.tistory.pentode.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.pentode.service.BoardService;
import com.tistory.pentode.service.dao.BoardDAO;
import com.tistory.pentode.vo.TransferVO;
import com.tistory.pentode.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardMapper;
	
	@Override
	@Transactional
	public List<BoardVO> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	@Transactional
	public Map<String, Object> mapProcedureList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", new Integer(2));
		map.put("name", "홍길동");
		boardMapper.mapProcedureList(map);
		return map;
	}
	
	@Override
	@Transactional
	public TransferVO procedureList() throws Exception {
		TransferVO container = new TransferVO();
		container.setNum(2);
		container.setName("홍길동");
		boardMapper.procedureList(container);
		return container;
	}
	
	@Override
	@Transactional
	public TransferVO anonymousBlockList() throws Exception {
		TransferVO container = new TransferVO();
		container.setNum(2);
		container.setName("홍길동");
		boardMapper.anonymousBlockList(container);
		return container;
	}
}
