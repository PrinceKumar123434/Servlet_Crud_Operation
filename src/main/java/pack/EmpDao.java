package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao 
{
	public static Connection getConnection()
	{
	Connection con=null;

	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/servlet","root","");


	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}

	//Saving Record 
	public static int save(Emp e)
	{
		int status=0;
		try
		{
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into user (name,password,email,city,course) values(?,?,?,?,?)");
		ps.setString(1,e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4,e.getCity());
		ps.setString(5, e.getCourse());
		
		status=ps.executeUpdate();
		con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
	
		}
		return status;
	}

	//ViewAll Records
	public static List<Emp> getAllEmployees(){  
	    List<Emp> list=new ArrayList<Emp>();  
	      
	    try{  
	        Connection con=EmpDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from user");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Emp e=new Emp();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setPassword(rs.getString(3));  
	            e.setEmail(rs.getString(4));  
	            e.setCity(rs.getString(5)); 
	            e.setCourse(rs.getString(6));
	            list.add(e);  
	        }  
	        con.close();  
	    }catch(Exception e){e.printStackTrace();
}  
	      
	    return list;  
	}

	//Delete Record
	public static int delete(int id){  
	    int status=0;  
	    try{  
	        Connection con=EmpDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
	        ps.setInt(1,id);  
	        status=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception e){e.printStackTrace();
}  
	      
	    return status;  
	}	
    //Update Record
	  public static int update(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update user set name=?,password=?,email=?,city=?,course=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCity());  
	            ps.setString(5,e.getCourse());
	            ps.setInt(6,e.getId());  
	              
	            status=ps.executeUpdate();  
	            con.close();  
	        }catch(Exception ex){System.out.println(ex);}  
	          
	        return status; 
	    }
	
	   //Get Employee Details by Id
	    public static Emp getEmployeeById(int id){  
	        Emp e=new Emp();  
	           try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCity(rs.getString(5)); 
	                e.setCourse(rs.getString(6));
	            }  
	            con.close();  
	        }catch(Exception ex){System.out.println(ex);}  
	          return e;  
	    }	  
	  
}

