package com.fo_art.model;

import java.util.*;
import java.sql.*;

public class Fo_artJDBCDAO implements Fo_artDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "ba103g4";
	String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO FO_ART (ART_NO, MEM_AC, FO_DATE) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT ART_NO, MEM_AC, to_char(FO_DATE,'yyyy-mm-dd') FO_DATE FROM FO_ART order by ART_NO";
		private static final String GET_ONE_STMT = 
			"SELECT ART_NO,MEM_AC,to_char(FO_DATE,'yyyy-mm-dd') FO_DATE FROM FO_ART where ART_NO = ?";
		private static final String DELETE = 
			"DELETE FROM FO_ART where ART_NO = ? AND MEM_AC = ?";
		private static final String UPDATE = 
			"UPDATE FO_ART set MEM_AC=?, FO_DATE=?,where ART_NO = ?";
	@Override
	public void insert(Fo_artVO fo_artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, fo_artVO.getArt_no());
			pstmt.setString(2, fo_artVO.getMem_ac());
			pstmt.setDate(3, fo_artVO.getFo_date());

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
	public void update(Fo_artVO fo_artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, fo_artVO.getArt_no());
			pstmt.setString(2, fo_artVO.getMem_ac());
			pstmt.setDate(3, fo_artVO.getFo_date());
			
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
	public Fo_artVO findByPrimaryKey(String art_no)  {

		Fo_artVO fo_artVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, art_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// fo_artVO 也稱為 Domain objects
				fo_artVO = new Fo_artVO();
				fo_artVO.setArt_no(rs.getString("ART_NO"));
				fo_artVO.setMem_ac(rs.getString("MEM_AC"));
				fo_artVO.setFo_date(rs.getDate("FO_DATE"));
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
		return fo_artVO;
	}

	@Override
	public List<Fo_artVO> getAll() {
		List<Fo_artVO> list = new ArrayList<Fo_artVO>();
		Fo_artVO fo_artVO = null;

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
			fo_artVO = new Fo_artVO();
			fo_artVO.setArt_no(rs.getString("ART_NO"));
			fo_artVO.setMem_ac(rs.getString("MEM_AC"));
			fo_artVO.setFo_date(rs.getDate("FO_DATE"));
			list.add(fo_artVO); // Store the row in the list
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

		Fo_artJDBCDAO dao = new Fo_artJDBCDAO();

//				// 新增
//				Fo_artVO fo_artVO1 = new Fo_artVO();
//				fo_artVO1.setART_NO("W1000000009");
//				fo_artVO1.setMEM_AC("BA85cc");
//				fo_artVO1.setFO_DATE(java.sql.Date.valueOf("2017-09-16"));
//				dao.insert(fo_artVO1);


////				// 修改
//				Fo_artVO fo_artVO2 = new Fo_artVO();
//				fo_artVO2.setART_NO("W1000000003");
//				fo_artVO2.setMEM_AC("BA85cc");
//				fo_artVO2.setFO_DATE(java.sql.Date.valueOf("2017-09-14"));
//				dao.update(fo_artVO2);
				
				
				// 刪除   ******待修正******
//				dao.delete("W1000000003","mamabeak");

				// 查詢
				Fo_artVO fo_artVO3 = dao.findByPrimaryKey("W1000000001");
				System.out.print(fo_artVO3.getArt_no() + ",");
				System.out.print(fo_artVO3.getMem_ac() + ",");
				System.out.println(fo_artVO3.getFo_date());
				System.out.println("---------------------");
				
				

				// 查詢
				List<Fo_artVO> list = dao.getAll();
				for (Fo_artVO aFo_art : list) {
					System.out.print(aFo_art.getArt_no() + ",");
					System.out.print(aFo_art.getMem_ac() + ",");
					System.out.print(aFo_art.getFo_date());
					System.out.println();
		}
	}
}