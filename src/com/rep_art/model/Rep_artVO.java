package com.rep_art.model;

import java.sql.Date;

public class Rep_artVO {

	public String art_no;
	public String mem_ac;
	public String rep_reason;
	public String rep_cont;
	public Date rep_date;
	public String deal_stat;
	public String deal_stat_cont;
	public Date deal_date;
	
	
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
	public String getRep_reason() {
		return rep_reason;
	}
	public void setRep_reason(String rep_reason) {
		this.rep_reason = rep_reason;
	}
	public String getRep_cont() {
		return rep_cont;
	}
	public void setRep_cont(String rep_cont) {
		this.rep_cont = rep_cont;
	}
	public Date getRep_date() {
		return rep_date;
	}
	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}
	public String getDeal_stat() {
		return deal_stat;
	}
	public void setDeal_stat(String deal_stat) {
		this.deal_stat = deal_stat;
	}
	public String getDeal_stat_cont() {
		return deal_stat_cont;
	}
	public void setDeal_stat_cont(String deal_stat_cont) {
		this.deal_stat_cont = deal_stat_cont;
	}
	public Date getDeal_date() {
		return deal_date;
	}
	public void setDeal_date(Date deal_date) {
		this.deal_date = deal_date;
	}

	
}
