package com.like_reply.model;

import java.util.List;

public interface Like_replyDAO_interface {

	public void insert(Like_replyVO like_replyVO);
	public void update(Like_replyVO like_replyVO);
	public void delete(String reply_no, String mem_ac);
	public Like_replyVO findByPrimaryKey(String reply_no, String mem_ac);
	public List<Like_replyVO> getAll();
}
