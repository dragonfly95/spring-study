package com.tistory.pentode.vo;

public class ChagyebuVO {
	
	private Integer num;
	private String date;
	private String type;
	private Integer amount;
	private Integer mileage;
	private Integer price;
	private String repair;
	private String complete;
	private String note;
	
	private Integer page;
	private Integer first;
	private Integer last;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getRepair() {
		return repair;
	}
	public void setRepair(String repair) {
		this.repair = repair;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	@Override
	public String toString() {
		return "ChagyebuVO [num=" + num + ", date=" + date + ", type=" + type + ", amount=" + amount + ", mileage="
				+ mileage + ", price=" + price + ", repair=" + repair + ", complete=" + complete + ", note=" + note
				+ ", page=" + page + ", first=" + first + ", last=" + last + "]";
	}
	
	
}
