package com.reply.model;

import java.util.List;

public interface ReplyDAO_interface {
	public void insert(ReplyVO replyVO);
	public void update(ReplyVO replyVO);
	public void delete(String reply_no);
	public ReplyVO findByPrimaryKey(String reply_no);
	public List<ReplyVO> getAll();
}
