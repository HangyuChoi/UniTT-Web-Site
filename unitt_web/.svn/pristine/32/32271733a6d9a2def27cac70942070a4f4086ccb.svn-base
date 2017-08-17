package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DBAction {
   public static DBAction instance;
   public Connection conn;
   public DataSource ds;
   public DBAction(){
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@210.123.255.152:1521:orcl";
      String user = "hr";
      String user_pw = "hr";
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, user, user_pw);
         System.out.println("Driver Loading Successful");
      } catch (ClassNotFoundException e) {
         System.out.println("Error : " + e.getMessage());
      } catch (SQLException ex) {
         System.out.println("SQLError : " + ex.getMessage());
      }
   }
   public static DBAction getInstance(){
      if(instance == null) instance = new DBAction();
      return instance;
   }
   public Connection getConnection(){
      return this.conn;
   }
}