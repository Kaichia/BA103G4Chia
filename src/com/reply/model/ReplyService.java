package com.reply.model;

import java.util.List;


public class ReplyService {

	private ReplyDAO_interface dao;

	public ReplyService() {
		dao = new ReplyDAO();
	}

	public ReplyVO addReply(String art_no,String mem_ac,String reply_cont,
			java.sql.Date reply_date) {

		ReplyVO replyVO = new ReplyVO();

		replyVO.setArt_no(art_no);
		replyVO.setMem_ac(mem_ac);
		replyVO.setReply_cont(reply_cont);
		replyVO.setReply_date(reply_date);
		dao.insert(replyVO);
		
		

		return replyVO;
	}

	public ReplyVO updateReply(String art_no, String mem_ac, String reply_cont,
			java.sql.Date  reply_date, String reply_no) {

		ReplyVO replyVO = new ReplyVO();

		replyVO.setArt_no(art_no);
		replyVO.setMem_ac(mem_ac);
		replyVO.setReply_cont(reply_cont);
		replyVO.setReply_date(reply_date);
		replyVO.setReply_no(reply_no);
		
		dao.update(replyVO);

		return replyVO;
	}

	public void deleteReply(String reply_no) {
		dao.delete(reply_no);
	}

	public ReplyVO getOneReply(String reply_no) {
		return dao.findByPrimaryKey(reply_no);
	}

	public List<ReplyVO> getAll() {
		return dao.getAll();
	}
}