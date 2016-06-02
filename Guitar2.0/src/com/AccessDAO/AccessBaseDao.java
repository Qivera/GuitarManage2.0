package com.AccessDAO;

import java.sql.*;

public class AccessBaseDao {
	Connection con = null;  
    Statement s = null;  
    ResultSet rs=null;  
      
    // 得到联接  
    public static Connection getConnection(){
    	Connection con = null;  
        try {  
            // 加载JDBC-ODBC桥驱动程序  
            Class.forName("com.hxtt.sql.access.AccessDriver");  
 
            con=DriverManager.getConnection("jdbc:Access:///F:/Guitars.mdb");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return con;  
    }  
      
    /** 
     * 关闭数据源 
     * @return 
     */  
    public  static void CloseConnection(Connection conn,ResultSet rs,Statement s){  
        try {  
            if (rs!=null) {  
                rs.close();  
            }  
            if (s!=null) {  
                s.close();  
            }  
            if (conn!=null) {  
                conn.close();      
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }

	public static void closeConnection(Connection conn) {
		// TODO Auto-generated method stub
		 try { 
	            if (conn!=null) {  
	                conn.close();      
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	}

	public void close() {
		// TODO Auto-generated method stub
		try
		{
			this.con.close() ;
		}
		catch (Exception e)
		{
		}
	}  
}  