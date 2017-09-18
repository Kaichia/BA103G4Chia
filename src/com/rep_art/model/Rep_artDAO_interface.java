package com.rep_art.model;

import java.util.List;

public interface Rep_artDAO_interface {
	
	public void insert(Rep_artVO rep_artVO);
	public void update(Rep_artVO rep_artVO);
	public void delete(Integer art_no);
	public Rep_artVO findByPrimaryKey(Integer art_no);
	public List<Rep_artVO> getAll();
}
