package cn.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.NewsCommentDao;

public class NewsCommentDaoImpl extends BaseDao implements NewsCommentDao {

	@Override
	public void getNewsCommentListByNewsId(int newsId) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "select * from news_comment where newsId=?";
			Object[] params = {newsId}; 
			try {
				ResultSet rs = this.executeQuery(sql, params);
				while(rs.next()){
					int id = rs.getInt("id");
					int nId = rs.getInt("newsId");
					String content = rs.getString("content");
					String author = rs.getString("author");
					String ip = rs.getString("ip");
					Timestamp createDate = rs.getTimestamp("createDate");
					System.out.println("id: " + id + "\t newsId: " + nId + " \t content: " + content + "\t author: " + author + "\t createDate: " + createDate);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void add(int id, int newsId, String content, String author,
			String ip, Date createDate) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "insert into news_comment (id,newsId,ip," +
					"content,author,createDate) values(?,?,?,?,?,?)";
			Object[] params = {id,newsId,ip,content,author,createDate};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("add success!");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
			
		}
	}

	@Override
	public void update(int id, String content) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "update news_comment set content=? where id = ?";
			Object[] params = {content,id};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("update success!");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "delete from news_comment where id = ?";
			Object[] params = {id};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("delelte by id success!");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}

	}

	@Override
	public void deleteByNewsId(int newsId) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "delete from news_comment where newsId=?";
			Object[] params = {newsId};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("delete by newsId success!");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

}
