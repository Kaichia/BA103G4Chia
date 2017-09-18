package com.like_art.model;

import java.util.List;

public interface Like_artDAO_interface {
	
	public void insert(Like_artVO like_artVO);
	public void update(Like_artVO like_artVO);
	public void delete(String art_no ,String mem_ac);
	public Like_artVO findByPrimaryKey(String art_no,String mem_ac);
	public List<Like_artVO> getAll();
}
