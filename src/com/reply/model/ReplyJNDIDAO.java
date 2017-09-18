package com.reply.model;

import java.util.*;
import java.sql.*;

public class ReplyJNDIDAO implements ReplyDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "ba103g4";
	String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO REPLY (REPLY_NO,ART_NO,MEM_AC,REPLY_CONT,REPLY_DATE) VALUES ('E' ||REPLY_NO_seq.NEXTVAL, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT REPLY_NO,ART_NO,MEM_AC,REPLY_CONT,to_char(REPLY_DATE,'yyyy-mm-dd') REPLY_DATE FROM REPLY order by REPLY_NO";
		private static final String GET_ONE_STMT = 
			"SELECT REPLY_NO,ART_NO,MEM_AC,REPLY_CONT,to_char(REPLY_DATE,'yyyy-mm-dd') REPLY_DATE FROM REPLY where REPLY_NO = ?";
		private static final String DELETE = 
			"DELETE FROM REPLY where REPLY_NO = ?";
		private static final String UPDATE = 
			"UPDATE REPLY set ART_NO=?, MEM_AC=?, REPLY_CONT=?, REPLY_DATE=? where REPLY_NO = ?";
	@Override
	public void insert(ReplyVO replyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, replyVO.getArt_no());
			pstmt.setString(2, replyVO.getMem_ac());
			pstmt.setString(3, replyVO.getReply_cont());
			pstmt.setDate(4, replyVO.getReply_date());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ReplyVO replyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, replyVO.getArt_no());
			pstmt.setString(2, replyVO.getMem_ac());
			pstmt.setString(3, replyVO.getReply_cont());
			pstmt.setDate(4, replyVO.getReply_date());
			pstmt.setString(5, replyVO.getReply_no());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(String reply_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, reply_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ReplyVO findByPrimaryKey(String reply_no)  {

		ReplyVO replyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, reply_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				replyVO = new ReplyVO();
				replyVO.setReply_no(rs.getString("REPLY_NO"));
				replyVO.setArt_no(rs.getString("ART_NO"));
				replyVO.setMem_ac(rs.getString("MEM_AC"));
				replyVO.setReply_cont(rs.getString("REPLY_CONT"));
				replyVO.setReply_date(rs.getDate("REPLY_DATE"));
			}


			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return replyVO;
	}

	@Override
	public List<ReplyVO> getAll() {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		ReplyVO replyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			// artVO 也稱為 Domain objects
			replyVO = new ReplyVO();
			replyVO.setReply_no(rs.getString("REPLY_NO"));
			replyVO.setArt_no(rs.getString("ART_NO"));
			replyVO.setMem_ac(rs.getString("MEM_AC"));
			replyVO.setReply_cont(rs.getString("REPLY_CONT"));
			replyVO.setReply_date(rs.getDate("REPLY_DATE"));
			list.add(replyVO); // Store the row in the list
		}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}