package com.tistory.pentode.service;

import java.util.List;
import java.util.Map;

import com.tistory.pentode.vo.TransferVO;
import com.tistory.pentode.vo.BoardVO;

public interface BoardService {
	List<BoardVO> selectBoardList() throws Exception;
	Map<String, Object> mapProcedureList() throws Exception;
	TransferVO procedureList() throws Exception;
	TransferVO anonymousBlockList() throws Exception;
}
