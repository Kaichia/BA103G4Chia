package com.like_art.model;

import java.util.List;


public class Like_artService {

	private Like_artDAO_interface dao;

	public Like_artService() {
		dao = new Like_artDAO();
	}

	public Like_artVO Like_art(String art_no, String mem_ac) {

		Like_artVO like_artVO = new Like_artVO();

		like_artVO.setArt_no(art_no);
		like_artVO.setMem_ac(mem_ac);
		
		dao.insert(like_artVO);
		
		

		return like_artVO;
	}

	public Like_artVO updateLike_art(String art_no, String mem_ac) {

		Like_artVO like_artVO = new Like_artVO();

		like_artVO.setArt_no(art_no);
		like_artVO.setMem_ac(mem_ac);
	
		dao.update(like_artVO);

		return like_artVO;
	}

	public void deleteLike_art(String art_no, String mem_ac) {
		dao.delete(art_no, mem_ac);
	}

	public Like_artVO getOneLike_art(String art_no, String mem_ac) {
		return dao.findByPrimaryKey(art_no, mem_ac);
	}

	public List<Like_artVO> getAll() {
		return dao.getAll();
	}
}