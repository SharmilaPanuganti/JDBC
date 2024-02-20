package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import manage.ConnectionProvider;
import model.Student;
public class StudentDAO {
   
	public static boolean insertStudentToDB(Student st) throws ClassNotFoundException, SQLException {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createConn();
		try {
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		//PreparedStatement..
		PreparedStatement ps = con.prepareStatement(q);
		//set the value of parameters
		ps.setString(1, st.getsName());
		ps.setString(2,st.getsPhone());
		ps.setString(3, st.getsCity());
		
		//execute...
		ps.executeUpdate();
		f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
    public static boolean updateStudent(Student st) throws ClassNotFoundException, SQLException {
        boolean f = false;
        // JDBC code...
        Connection con = ConnectionProvider.createConn();
        try {
            String q = "update students set sname=?, sphone=?, scity=? where studentId=?";
            // PreparedStatement..
            PreparedStatement ps = con.prepareStatement(q);
            // set the value of parameters
            ps.setString(1, st.getsName());
            ps.setString(2, st.getsPhone());
            ps.setString(3, st.getsCity());
            ps.setInt(4, st.getStudentId()); // Assuming you have a method like getStudentId() in your Student class
    
            // execute...
            ps.executeUpdate();
            f = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
            if (con != null) {
                con.close();
            }
        }
        return f;
    }
 public static boolean ifExists(int id) throws SQLException, ClassNotFoundException{
    Connection con = ConnectionProvider.createConn();
    String query = "SELECT COUNT(*) FROM students WHERE studentId=?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        }
    }
 }    
	
	public static boolean deleteStudent(int userId) throws ClassNotFoundException, SQLException {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createConn();
		try {
		String q="delete from students where studentId=?";
		//PreparedStatement..
		PreparedStatement ps = con.prepareStatement(q);
		//set the value of parameters
		ps.setInt(1, userId);
			
		//execute...
		ps.executeUpdate();
		f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean showAllStudents() throws ClassNotFoundException, SQLException {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createConn();
		try {
		String q="select * from students";
		//PreparedStatement..
		Statement stm = con.createStatement();
			
		//execute...
		ResultSet rs = stm.executeQuery(q);
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String phone=rs.getString(3);
			String city=rs.getString("scity");
			
			System.out.println("Id : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone No : "+phone);
			System.out.println("City : "+city);
			System.out.println("-----------------------");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
