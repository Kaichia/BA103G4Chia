package com.art.model;

import java.util.List;


public class ArtService {

	private ArtDAO_interface dao;

	public ArtService() {
		dao = new ArtDAO();
	}

	public ArtVO addArt(String mem_ac, String art_title, java.sql.Date art_date,
			java.sql.Date  art_last_modify, String art_tag, String art_cont) {

		ArtVO artVO = new ArtVO();

		artVO.setMem_ac(mem_ac);
		artVO.setArt_title(art_title);
		artVO.setArt_date(art_date);
		artVO.setArt_last_modify(art_last_modify);
		artVO.setArt_tag(art_tag);
		artVO.setArt_cont(art_cont);
		dao.insert(artVO);
		
		

		return artVO;
	}

	public ArtVO updateArt(String mem_ac, String art_title, java.sql.Date art_date,
			java.sql.Date  art_last_modify, String art_tag, String art_cont, String art_no ) {

		ArtVO artVO = new ArtVO();

		artVO.setMem_ac(mem_ac);
		artVO.setArt_title(art_title);
		artVO.setArt_date(art_date);
		artVO.setArt_last_modify(art_last_modify);
		artVO.setArt_tag(art_tag);
		artVO.setArt_cont(art_cont);
		artVO.setArt_no(art_no);
		dao.update(artVO);

		return artVO;
	}

	public void deleteArt(String art_no) {
		dao.delete(art_no);
	}

	public ArtVO getOneArt(String art_no) {
		return dao.findByPrimaryKey(art_no);
	}

	public List<ArtVO> getAll() {
		return dao.getAll();
	}
}