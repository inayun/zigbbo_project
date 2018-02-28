package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.SellingDTO;
import zigbo.model.dto.SellingMemberDTO;
import zigbo.model.util.DBUtil;
import java.util.Date;

public class SellingDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	/*
	 * CRUD - Create(add/insert),
	 * 		- Read(one/all)
	 * 		- Update
	 * 		- Delete
	 * 
	addSelling //�Ǹű� �ۼ���
	getSelling //id�� �Ǹű� �˻�
	getAllSelling //��� �Ǹű� �˻�
	updateSellingViews //��ȸ�� ����
	updateSellingProgress //������� ����
	deleteSelling //�� ����
	
	getMostViews //View ������ 6�� �ҷ�����
	getMostRecent //�ֽż� 6�� �ҷ�����
	getMostInterest //������ 6�� �ҷ�����
	
	 */
	
	
	public static boolean addSelling(SellingDTO selling) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addSelling"));
			pstmt.setInt(1, selling.getMemberCode());
			pstmt.setInt(2, selling.getItemCode());
			pstmt.setInt(3, selling.getViews());
			pstmt.setString(4, selling.getLocation());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static SellingDTO getSelling(int sellingCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SellingDTO selling = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSelling"));
			pstmt.setInt(1, sellingCode);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				selling = new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return selling;
	}
	
	public static ArrayList<SellingDTO> getAllSelling() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllSelling"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingDTO>();
			while(rset.next()) {
				list.add(new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static boolean updateSellingViews(int sellingCode) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateSellingViews"));
			pstmt.setInt(1, sellingCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateSellingProgress(int sellingCode) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateSellingProgress"));
			pstmt.setInt(1, sellingCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static ArrayList<SellingDTO> getMostViews() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMostViews"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingDTO>();
			while(rset.next()){
				list.add(new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<SellingDTO> getMostRecent() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMostRecent"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingDTO>();
			while(rset.next()){
				list.add(new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<SellingDTO> getMostInterest() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMostInterest"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingDTO>();
			while(rset.next()){
				list.add(new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<SellingDTO> getSellingofMember(int memberCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSellingofMember"));
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingDTO>();
			while(rset.next()){
				list.add(new SellingDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<SellingMemberDTO> getAllSellingMember() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellingMemberDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllSellingMember"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellingMemberDTO>();
			while(rset.next()) {
				list.add(new SellingMemberDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getDate(5), rset.getString(6), rset.getString(7), rset.getString(8)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	
}
