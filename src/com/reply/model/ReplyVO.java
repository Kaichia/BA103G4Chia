package com.reply.model;

import java.sql.Date;

public class ReplyVO implements java.io.Serializable{
	
	private String reply_no;
	private String art_no;
	private String mem_ac;
	private String reply_cont;
	private Date reply_date;
	
	public String getReply_no() {
		return reply_no;
	}
	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}
	public String getArt_no() {
		return art_no;
	}
	public void setArt_no(String art_no) {
		this.art_no = art_no;
	}
	public String getMem_ac() {
		return mem_ac;
	}
	public void setMem_ac(String mem_ac) {
		this.mem_ac = mem_ac;
	}
	public String getReply_cont() {
		return reply_cont;
	}
	public void setReply_cont(String reply_cont) {
		this.reply_cont = reply_cont;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	
	
}
