package com.tistory.pentode.service;

import java.util.Map;

import com.tistory.pentode.vo.ChagyebuVO;

public interface ChagyebuService {
	Map<String, Object> selectChagyebuList(ChagyebuVO vo) throws Exception;
}
