package com.fo_art.model;

import java.sql.Date;

public class Fo_artVO implements java.io.Serializable{
	
	public String art_no;
	public String mem_ac;
	public Date fo_date;
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
	public Date getFo_date() {
		return fo_date;
	}
	public void setFo_date(Date fo_date) {
		this.fo_date = fo_date;
	}
	
	
}
