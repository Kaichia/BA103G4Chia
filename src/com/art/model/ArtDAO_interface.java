package com.art.model;

import java.util.List;

public interface ArtDAO_interface {

	public void insert(ArtVO artVO);
	public void update(ArtVO artVO);
	public void delete(String art_no);
	public ArtVO findByPrimaryKey(String art_no);
	public List<ArtVO> getAll();
	
	
}
