package dbconn;

import books.BookController;
import books.bookitem;
import borrower.borroweritems;
//import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Educ
 */
public class connecteddb {

    public static Connection con;

    public Connection getconnectiondb() {
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                System.out.println("The connection was successful");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return null;
    }
    
    public int chechlogin(String name, String password) {
        getconnectiondb();
        if (con == null) {
            return -1;
        }
        
        String sql = "SELECT * FROM users WHERE (username =? AND password =?)";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setString(1, name);
            prest.setString(2, password);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                return 0;
            }
        } catch (SQLException se) {

        }
        return 1;
    }
    
    PreparedStatement prest = null;
    
    //add book
    public int addbo(int id, String name, String description) {
        getconnectiondb();
        if (con == null) {
            return -1;
        }
        
        String sql = "INSERT INTO books(`id`,`name`,`description`)VALUES(?,?,?)";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setInt(1, id);
            prest.setString(2, name);
            prest.setString(3, description);
            prest.execute();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;

    }
    // searchbook   
     public bookitem searchbook(int id){
        String sql = "SELECT * FROM books WHERE id = ? ;";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setInt(1, id);
          ResultSet set =   prest.executeQuery();
          
          while(set.next()){
          
              System.out.println( set.getString("name"));  
              bookitem book = new bookitem();
              book.setId(set.getInt("id"));
              book.setName(set.getString("name"));
              book.setDescription(set.getString("description"));
            return book;
          }
          
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
        return null;
    }
     
     //update 
         public int updatabook(int id, String name, String description){
            getconnectiondb();
        if (con == null) {
            return -1;
        }
        
        String sql = "UPDATE `books` SET `name`=?,`description`=? where id = ?";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setString(1, name);
            prest.setString(2, description);
            prest.setInt(3, id);
            int i = prest.executeUpdate();
            if(i == 1){
                System.out.println("updated");
            }else{
                System.out.println("error to updata");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;

}
   //delete 
    public int delete(String id) {
        
          getconnectiondb();
        if (con == null) {
            return -1;
        }
        
        String sql = "Delete from `books` where id = ?";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
         
            prest.setInt(1, Integer.parseInt(id));
            
            int i = prest.executeUpdate();
            if(i == 1){
                System.out.println("deleted");
                
            }else{
                System.out.println("error to deleted");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;

    }
    //showall
    public  ArrayList<bookitem>  showAll() {
        
        ArrayList<bookitem> list = new ArrayList<bookitem>();
        try {
            String sql = "SELECT * FROM books";
            
            prest = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs =   prest.executeQuery();
            
            
            
            while (rs.next()) {
                  list.add(new bookitem(rs.getInt("id") , rs.getString("name") ,rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(connecteddb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }     
         
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////            borrower           /////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int addborrow(int id, String fname, String lname, int mobile ,String email,String address ,String gender ) {
        getconnectiondb();
        if (con == null) {
            return -1;
        }
        String sql = "INSERT INTO `borrowers` (`id`, `fname`, `lname`, `mobile`, `email`, `address`, `gender`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setInt(1, id);
            prest.setString(2, fname);
            prest.setString(3, lname);
            prest.setInt(4, mobile);
            prest.setString(5, email);
            prest.setString(6, address);
            prest.setString(7, gender);
            prest.execute();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;

    }
    //search borrower
         public borroweritems searchborrower(int id){
        String sql = "SELECT * FROM borrowers WHERE id = ? ;";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setInt(1, id);
          ResultSet set =   prest.executeQuery();
          
          while(set.next()){
          
//              System.out.println( set.getString("name"));  
              borroweritems  borrower = new borroweritems();
               borrower.setId(set.getInt("id"));
               borrower.setFname(set.getString("fname"));
               borrower.setLname(set.getString("lname"));
               borrower.setMobile(set.getInt("mobile"));
               borrower.setAddress(set.getString("address"));
               borrower.setEmail(set.getString("email"));
               borrower.setGender(set.getString("gender"));
            return borrower;
          }
          
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
        return null;
    }
      //deleteborroer
       public int deleteborroer(String id) {
       getconnectiondb();
        if (con == null) {
            return -1;
        }
        String sql = "Delete from `borrowers` where id = ?";
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
         
            prest.setInt(1, Integer.parseInt(id));
            
            int i = prest.executeUpdate();
            if(i == 1){
                System.out.println("deleted");
                
            }else{
                System.out.println("error to deleted");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;

    }
       
       
       //showall borrower
         public  ArrayList<borroweritems> showAllborrower() {
        
        ArrayList<borroweritems> list = new ArrayList<borroweritems>();
        try {
            String sql = "SELECT * FROM borrowers";
            
            prest = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs =   prest.executeQuery();

            while (rs.next()) {
                  list.add(new borroweritems(rs.getInt("id") , rs.getString("fname") ,rs.getString("lname"),
                  rs.getInt("mobile") ,rs.getString("email"),rs.getString("address"),rs.getString("gender")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(connecteddb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
           
      //update borrower
      public int updataborrower(int id, String fname, String lname , int mobile , String email , String address , String gender){
        getconnectiondb();
        if (con == null) {
            return -1;
        }
        
        String sql = "UPDATE `borrowers` SET `fname`=?,`lname`=?,`mobile`=?,`email`=?,`address`=?,`gender`=? where id = ?";
       
        try {
            prest = (PreparedStatement) con.prepareStatement(sql);
            prest.setString(1, fname);
            prest.setString(2, lname);
            prest.setInt(3, mobile);
            prest.setString(4, email);
            prest.setString(5, address);
            prest.setString(6, gender);
            prest.setInt(7, id);
            int i = prest.executeUpdate();
            if(i == 1){
                System.out.println("updated");
            }else{
                System.out.println("error to updata");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return 1;
 
}  
     
}