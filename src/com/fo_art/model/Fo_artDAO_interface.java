package com.fo_art.model;

import java.util.List;

public interface Fo_artDAO_interface {
	
	public void insert(Fo_artVO fo_artVO);
	public void update(Fo_artVO fo_artVO);
	public void delete(String art_no,String mem_ac);
	public Fo_artVO findByPrimaryKey (String art_no);
	public List<Fo_artVO> getAll();
	
}
