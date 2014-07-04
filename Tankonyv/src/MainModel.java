import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class MainModel {
	
	public List<String> getSchoolClasses(){
		List<String> result= new ArrayList<String>();
		Connection c = null;
		Statement stmt = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:res/adatbazis.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT DISTINCT DiakOsztaly FROM tdiak;" );
	      while ( rs.next() ) {
	         String className = rs.getString("DiakOsztaly");
	         //System.out.println( className );
	         result.add(className);
	      }
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    return result;
	}
	
	//itt ugye nem sima string kellene legyen
	public List<String> getStudentsInClass(String schoolClass, int year){
		List<String> result= new ArrayList<String>();
		Connection c = null;
		PreparedStatement stmt = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:res/adatbazis.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      String qry = "SELECT DISTINCT d.DiakAzon, d.DiakNev ";
	      qry += "FROM TDiakKonyv dk, TDiak d ";
	      qry += "WHERE dk.DiakAzon = d.DiakAzon ";
	      qry += "AND dk.Osztaly = ? ";
	      qry += "AND dk.Ev = ?";
	      
	      stmt = c.prepareStatement(qry);
	      stmt.setString(1, schoolClass);
	      stmt.setInt(2, year);
	      ResultSet rs = stmt.executeQuery();
	      while ( rs.next() ) {
	         String name = rs.getString(2);
	         System.out.println( name );
	         //result.add(className);
	      }
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		return result;
	}
}
