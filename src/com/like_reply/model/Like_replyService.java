package com.like_reply.model;

import java.util.List;


public class Like_replyService {

	private Like_replyDAO_interface dao;

	public Like_replyService() {
		dao = new Like_replyDAO();
	}

	public Like_replyVO addLike_reply(String reply_no, String mem_ac) {

		Like_replyVO like_replyVO = new Like_replyVO();

		like_replyVO.setReply_no(reply_no);
		like_replyVO.setMem_ac(mem_ac);
		
		dao.insert(like_replyVO);
		
		

		return like_replyVO;
	}

	public Like_replyVO updateLike_reply(String reply_no, String mem_ac) {

		Like_replyVO like_replyVO = new Like_replyVO();

		like_replyVO.setReply_no(reply_no);
		like_replyVO.setMem_ac(mem_ac);
	
		dao.update(like_replyVO);

		return like_replyVO;
	}

	public void deleteLike_reply(String reply_no, String mem_ac) {
		dao.delete(reply_no, mem_ac);
	}

	public Like_replyVO getOneLike_reply(String reply_no, String mem_ac) {
		return dao.findByPrimaryKey(reply_no, mem_ac);
	}

	public List<Like_replyVO> getAll() {
		return dao.getAll();
	}
}