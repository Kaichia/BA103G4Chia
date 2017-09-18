package com.fo_art.model;

import java.util.List;


public class Fo_artService {

	private Fo_artDAO_interface dao;

	public Fo_artService() {
		dao = new Fo_artDAO();
	}

	public Fo_artVO addFo_art(String art_no, String mem_ac, java.sql.Date fo_date) {

		Fo_artVO fo_artVO = new Fo_artVO();

		fo_artVO.setArt_no(art_no);
		fo_artVO.setMem_ac(mem_ac);
		fo_artVO.setFo_date(fo_date);
		
		dao.insert(fo_artVO);
		
		

		return fo_artVO;
	}

	public Fo_artVO updateFo_art(String art_no, String mem_ac, java.sql.Date fo_date) {

		Fo_artVO fo_artVO = new Fo_artVO();

		fo_artVO.setArt_no(art_no);
		fo_artVO.setMem_ac(mem_ac);
		fo_artVO.setFo_date(fo_date);
	
		dao.update(fo_artVO);

		return fo_artVO;
	}

	public void deleteFo_art(String art_no, String mem_ac) {
		dao.delete(art_no,mem_ac);
	}

	public Fo_artVO getOneFo_art(String art_no) {
		return dao.findByPrimaryKey(art_no);
	}

	public List<Fo_artVO> getAll() {
		return dao.getAll();
	}
}