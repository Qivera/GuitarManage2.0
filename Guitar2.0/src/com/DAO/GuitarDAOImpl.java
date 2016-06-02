package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.AccessDAO.AccessBaseDao;
import com.Model.Builder;
import com.Model.Guitar;
import com.Model.GuitarSpec;
import com.Model.Type;
import com.Model.Wood;

public class GuitarDAOImpl implements GuitarDAO {



@SuppressWarnings("static-access")
public List queryByLike(String cond) throws Exception  
     {  
	
	    List all = new ArrayList() ; 
        String sql = "SELECT serialNumber,price,builder,model,type,backWood,topWood FROM Guitar WHERE builder LIKE ? or type LIKE ? or model LIKE ?  or backWood LIKE ? or topWood LIKE ?" ;  
         PreparedStatement pstmt = null ;  
         AccessBaseDao bd = null ;  
         bd = new AccessBaseDao();  
         try  
        {  
            pstmt = bd.getConnection().prepareStatement(sql);  
            pstmt.setString(1,"%"+cond+"%") ;  
            pstmt.setString(2,"%"+cond+"%") ;  
            pstmt.setString(3,"%"+cond+"%") ;
            pstmt.setString(4,"%"+cond+"%") ;  
            pstmt.setString(5,"%"+cond+"%") ;
             ResultSet rs = pstmt.executeQuery() ;  
              while(rs.next())  
             {  
            	 Builder builder=Builder.valueOf(rs.getString("builder").toUpperCase()); 
            	 String model=rs.getString("model"); 
            	 Type type=Type.valueOf(rs.getString("type").toUpperCase()); 
            	 int numStrings=rs.getInt("numStrings"); 
            	 Wood backWood=Wood.valueOf(rs.getString("backWood").toUpperCase()); 
            	 Wood topWood=Wood.valueOf(rs.getString("topWood").toUpperCase()); 
            	 Guitar guitar=new Guitar(rs.getString(1), rs.getDouble(2),  
            			      new GuitarSpec(builder,model,type,numStrings,backWood,topWood)); 
            	 all.add(guitar);

              }  
              
             rs.close() ;  
             pstmt.close() ;  
         }  
       catch (Exception e)  
         {  
            System.out.println(e) ;  
             throw new Exception("操作中出现错误！！！") ;  
        }  
        finally  
        {  
            bd.close() ;  
        }  
        return all ;  
    }



 
  };  
