package com.art.model;

import java.sql.Clob;
import java.sql.Date;

public class ArtVO implements java.io.Serializable {

	private String art_no;
	private String mem_ac;
	private String art_title;
	private Date art_date;
	private Date art_last_modify;
	private String art_tag;
	private String art_cont;
	
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
	public String getArt_title() {
		return art_title;
	}
	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}
	public Date getArt_date() {
		return art_date;
	}
	public void setArt_date(Date art_date) {
		this.art_date = art_date;
	}
	public Date getArt_last_modify() {
		return art_last_modify;
	}
	public void setArt_last_modify(Date art_last_modify) {
		this.art_last_modify = art_last_modify;
	}
	public String getArt_tag() {
		return art_tag;
	}
	public void setArt_tag(String art_tag) {
		this.art_tag = art_tag;
	}
	public String getArt_cont() {
		return art_cont;
	}
	public void setArt_cont(String art_cont) {
		this.art_cont = art_cont;
	}
	
	


}


