package com.like_art.model;

import java.util.*;
import java.sql.*;

public class Like_artJDBCDAO implements Like_artDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "ba103g4";
	String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO LIKE_ART (ART_NO,MEM_AC) VALUES (?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT ART_NO,MEM_AC FROM like_art order by ART_NO";
		private static final String GET_ONE_STMT = 
			"SELECT ART_NO,MEM_AC FROM LIKE_ART where ART_NO = ? and MEM_AC = ? ";
		private static final String DELETE = 
			"DELETE FROM LIKE_ART where ART_NO = ? AND MEM_AC = ?";
		private static final String UPDATE = 
			"";
	@Override
	public void insert(Like_artVO like_artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, like_artVO.getArt_no());
			pstmt.setString(2, like_artVO.getMem_ac());

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
	public void update(Like_artVO like_artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, like_artVO.getMem_ac());
			pstmt.setString(2, like_artVO.getArt_no());

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
	public void delete(String art_no,String mem_ac) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, art_no);
			pstmt.setString(2, mem_ac);

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
	public Like_artVO findByPrimaryKey(String art_no,String mem_ac)  {

		Like_artVO like_artVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, art_no);
			pstmt.setString(2, mem_ac);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				like_artVO = new Like_artVO();
				like_artVO.setArt_no(rs.getString("ART_NO"));
				like_artVO.setMem_ac(rs.getString("MEM_AC"));
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
		return like_artVO;
	}

	@Override
	public List<Like_artVO> getAll() {
		List<Like_artVO> list = new ArrayList<Like_artVO>();
		Like_artVO like_artVO = null;

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
			like_artVO = new Like_artVO();
			like_artVO.setArt_no(rs.getString("ART_NO"));
			like_artVO.setMem_ac(rs.getString("MEM_AC"));
			list.add(like_artVO); // Store the row in the list
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

	public static void main(String[] args) {

		Like_artJDBCDAO dao = new Like_artJDBCDAO();

				// 新增
				Like_artVO ike_artVO1 = new Like_artVO();
				ike_artVO1.setArt_no("W1000000002");
				ike_artVO1.setMem_ac("dantea");
				dao.insert(ike_artVO1);

				// 修改 ***不使用***
//				Like_artVO like_artVO2 = new ArtVO();
//				like_artVO2.setArt_no("W1000000001");
//				like_artVO2.setMem_ac("zxc123");
//				dao.update(artVO2);

				// 刪除
				dao.delete("W1000000002","dantea");

				// 查詢
				Like_artVO like_artVO3 = dao.findByPrimaryKey("W1000000001","mamabeak");
				System.out.print(like_artVO3.getArt_no() + ",");
				System.out.println(like_artVO3.getMem_ac());
				System.out.println("---------------------");

				// 查詢
				List<Like_artVO> list = dao.getAll();
				for (Like_artVO lArt : list) {
					System.out.print(lArt.getArt_no() + ",");
					System.out.print(lArt.getMem_ac());
					System.out.println();
		}
	}
}