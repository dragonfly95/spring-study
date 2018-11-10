package com.tistory.pentode.service.dao;

import java.util.List;
import java.util.Map;

import com.tistory.pentode.vo.TransferVO;
import com.tistory.pentode.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws Exception;
	void mapProcedureList(Map<String, Object> map) throws Exception;
	void procedureList(TransferVO container) throws Exception;
	void anonymousBlockList(TransferVO container) throws Exception;
}
