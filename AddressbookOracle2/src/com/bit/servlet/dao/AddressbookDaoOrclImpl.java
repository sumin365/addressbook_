package com.bit.servlet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.servlet.model.AddressbookVo;
public class AddressbookDaoOrclImpl implements AddressbookDao {
		//	커넥션 메서드
		private Connection getConnection() throws SQLException {
			Connection conn = null;
			
			try {
				//	드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
				//	드라이버 매니저 -> 접속 얻어오기
				conn = DriverManager.getConnection(dburl, "C##SUMIN", "1234");
			} catch (ClassNotFoundException e) {
				System.err.println("드라이버 로딩 실패");
				e.printStackTrace();
			}
			
			return conn;
		}
		
		@Override
		public List<AddressbookVo> getList() {
			List<AddressbookVo> list = new ArrayList<>();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT no, name, tel, hp FROM phone_book " ;
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String tel = rs.getString(3);
					String hp = rs.getString(4);
					
					
					AddressbookVo vo = new AddressbookVo(no, name, tel, hp);
					//	리스트에 추가
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//	자원 정리
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e) {}
			}
			return list;
		}

		@Override
		public boolean insert(AddressbookVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int insertedCount = 0;
			
			try {
				conn = getConnection();
				String sql = "INSERT INTO phone_book " +
						"VALUES(seq_emaillist_pk.NEXTVAL, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getTel());
				pstmt.setString(3, vo.getHp());
				
				insertedCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return insertedCount == 1 ;
		}

		@Override
		public boolean delete(Long no) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int deletedCount = 0;
			
			try {
				conn = getConnection();
				String sql = "DELETE FROM phone_book " +
						"WHERE no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, no);
				
				deletedCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return deletedCount== 1 ;
		}
		
		
		
		
		
		
		
		
		

	
		public List<AddressbookVo> search (String a) {
			List<AddressbookVo> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "SELECT no, name, tel, hp FROM phone_book" +
						     "WHERE name like = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, "%" + a + "%" );
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					AddressbookVo vo = new AddressbookVo();
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String tel = rs.getString(3);
					String hp = rs.getString(4);
					list.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch(Exception e ) {
					e.printStackTrace();
				}
			}
			
			return list;
		}

	}
