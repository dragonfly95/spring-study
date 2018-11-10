package com.tistory.pentode.vo;

import java.io.Serializable;
import java.util.List;

public class TransferVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer num;
	private String name;
	private List<BoardVO> resultList;
	
	public TransferVO() {
	}
	
	public void setResultList(List<BoardVO> list) {
		this.resultList = list;
	}
	
	public List<BoardVO> getResultList() {
		return this.resultList;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
