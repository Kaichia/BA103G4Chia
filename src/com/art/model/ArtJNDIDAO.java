package com.art.model;

import java.util.*;
import java.sql.*;

public class ArtJNDIDAO implements ArtDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "ba103g4";
	String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO ART (ART_NO,MEM_AC,ART_TITLE,ART_DATE,ART_LAST_MODIFY,ART_TAG,ART_CONT) VALUES ('W' ||ART_NO_seq.NEXTVAL, ?,?,?,?,?,?)";
		private static final String GET_ALL_STMT = 
			"SELECT ART_NO,MEM_AC,ART_TITLE,to_char(ART_DATE,'yyyy-mm-dd')ART_DATE,to_char(ART_LAST_MODIFY,'yyyy-mm-dd')ART_LAST_MODIFY,ART_TAG,ART_CONT FROM ART order by ART_NO";
		private static final String GET_ONE_STMT = 
			"SELECT ART_NO,MEM_AC,ART_TITLE,to_char(ART_DATE,'yyyy-mm-dd')ART_DATE,to_char(ART_LAST_MODIFY,'yyyy-mm-dd')ART_LAST_MODIFY,ART_TAG,ART_CONT FROM ART where ART_NO = ?";
		private static final String DELETE = 
			"DELETE FROM ART where ART_NO = ?";
		private static final String UPDATE = 
			"UPDATE ART set MEM_AC=?,ART_TITLE=?, ART_DATE=?, ART_LAST_MODIFY=?,ART_TAG=?,ART_CONT=? where ART_NO =? ";
	@Override
	public void insert(ArtVO artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, artVO.getMem_ac());
			pstmt.setString(2, artVO.getArt_title());
			pstmt.setDate(3, artVO.getArt_date());
			pstmt.setDate(4, artVO.getArt_last_modify());
			pstmt.setString(5, artVO.getArt_tag());
			pstmt.setString(6, artVO.getArt_cont());

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
	public void update(ArtVO artVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, artVO.getMem_ac());
			pstmt.setString(2, artVO.getArt_title());
			pstmt.setDate(3, artVO.getArt_date());
			pstmt.setDate(4, artVO.getArt_last_modify());
			pstmt.setString(5, artVO.getArt_tag());
			pstmt.setString(6, artVO.getArt_cont());
			pstmt.setString(7, artVO.getArt_no());

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
	public void delete(String art_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, art_no);

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
	public ArtVO findByPrimaryKey(String art_no)  {

		ArtVO artVO = null;
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
				// empVo 也稱為 Domain objects
				artVO = new ArtVO();
				artVO.setArt_no(rs.getString("ART_NO"));
				artVO.setMem_ac(rs.getString("MEM_AC"));
				artVO.setArt_title(rs.getString("ART_TITLE"));
				artVO.setArt_date(rs.getDate("ART_DATE"));
				artVO.setArt_last_modify(rs.getDate("ART_LAST_MODIFY"));
				artVO.setArt_tag(rs.getString("ART_TAG"));
				artVO.setArt_cont(rs.getString("ART_CONT"));
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
		return artVO;
	}

	@Override
	public List<ArtVO> getAll() {
		List<ArtVO> list = new ArrayList<ArtVO>();
		ArtVO artVO = null;

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
			artVO = new ArtVO();
			artVO.setArt_no(rs.getString("ART_NO"));
			artVO.setMem_ac(rs.getString("MEM_AC"));
			artVO.setArt_title(rs.getString("ART_TITLE"));
			artVO.setArt_date(rs.getDate("ART_DATE"));
			artVO.setArt_last_modify(rs.getDate("ART_LAST_MODIFY"));
			artVO.setArt_tag(rs.getString("ART_TAG"));
			artVO.setArt_cont(rs.getString("ART_CONT"));
			list.add(artVO); // Store the row in the list
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