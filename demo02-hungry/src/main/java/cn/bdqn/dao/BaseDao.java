package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.bdqn.util.ConfigManager;

//操作数据库的基类
public class BaseDao {
	
	protected Connection connection;
	protected PreparedStatement pstm;
	protected ResultSet rs;

	//连接数据库
	public boolean getConnection(){
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String user = ConfigManager.getInstance().getString("user");
		String password = ConfigManager.getInstance().getString("password");
		try {
			//1 加载驱动
			Class.forName(driver);
			//2 获取数据库连接
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//通过tomcat数据源获取连接
	public Connection getConnectionDS(){
		try {
			//获取上下文对象
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news");
			connection = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	//查询操作select * from news_detail
	public ResultSet executeQuery(String sql,Object[] params){
		try {
			pstm = connection.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				pstm.setObject(i+1, params[i]);
			}
			rs = pstm.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	//增删改操作 delete from news_detail where id=? and title=?
	public int executeUpdate(String sql,Object[] params){
		int updateRows = 0;
		try {
			pstm = connection.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				pstm.setObject(i+1, params[i]);
			}
			updateRows = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			updateRows = -1;
		}
		
		return updateRows;
	}
	
	
	//释放资源
	public boolean closeResource(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(pstm != null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
}
