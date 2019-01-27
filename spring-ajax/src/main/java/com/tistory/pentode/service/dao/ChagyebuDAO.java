package com.tistory.pentode.service.dao;

import java.util.List;

import com.tistory.pentode.vo.ChagyebuVO;

public interface ChagyebuDAO {
	List<ChagyebuVO> selectChagyebuList(ChagyebuVO vo) throws Exception;
	Integer selectChagyebuTotal(ChagyebuVO vo) throws Exception;
}
