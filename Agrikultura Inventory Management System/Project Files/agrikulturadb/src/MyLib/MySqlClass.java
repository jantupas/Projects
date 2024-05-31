package MyLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author janed
 */
public class MySqlClass {
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    String user = "root";
    String password = "jeet";

    public void getConnection()
    {
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull", user, password);  //database connection
        }catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}  
    }      

    
    public void createRec(Product product) //creates and adds a new record to database
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="INSERT INTO PRODREC VALUES(" + product.getProdid()+ ",'" + product.getName()+ "','" + product.getStatus()+ "','" + product.getSellprc()+ "','" + product.getAcqprc()+ "','" + product.getQuantity() + "','" + product.getAcqdate() + "','" + product.getExpdate() + "' )";
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Added successfully!");
	}
	catch(SQLException se)
	{
            String msg="Cannot add. Product" + product.getProdid() + " already exists!";
            JOptionPane.showMessageDialog(null,msg);		
	}
    }
    
    public void updateRec(Product product, int oldProdid) //updates an existing record from the database
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="UPDATE PRODREC SET PRODID = " + product.getProdid()+ ", PRODNAME = '" + product.getName()+ "' , PRODSTATUS = '" + product.getStatus()+ "' , PRODSELLPRC = '" + product.getSellprc()+ "' , PRODACQPRC = '" + product.getAcqprc()+ "' , PRODQUANTITY = '" + product.getQuantity()+ "' , ACQDATE = '" + product.getAcqdate()+ "' , EXPDATE = '" + product.getExpdate()+ "' WHERE PRODID = " + oldProdid;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Updated successfully!");
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    public void deleteRec(int oldProdid) //permanently removes a record from the database
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="DELETE FROM PRODREC WHERE PRODID = " + oldProdid;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Deleted successfully!");
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    public void updateQty(int prodid, int quantity) //updates a product's quantity in the database
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="UPDATE PRODREC SET PRODQUANTITY = " + quantity + " WHERE PRODID = " + prodid;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Product Replenished!");
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
        
    }
    
    public void deleteExp(int prodid)  //removes an expired product from the database
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="DELETE FROM PRODREC WHERE PRODID = " + prodid;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Product Removed!");
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
        
    }
    
    public ArrayList<Product> displayRec() //returns all records in the database
    {
        ArrayList<Product> products=new ArrayList<Product>();
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String query = "SELECT * FROM PRODREC";
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                products.add(new Product(rs.getInt("PRODID"),rs.getString("PRODNAME"),rs.getString("PRODSTATUS"),rs.getDouble("PRODSELLPRC"),rs.getDouble("PRODACQPRC"),rs.getInt("PRODQUANTITY"),rs.getString("ACQDATE"),rs.getString("EXPDATE")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return products;
    }
    
    public ArrayList<Product> searchRec(int searchid)  //searches for a specific record in the database using ID
    {
        ArrayList<Product> products=new ArrayList<Product>();
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String query = "SELECT * FROM PRODREC WHERE PRODID = " + searchid;
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                products.add(new Product(rs.getInt("PRODID"),rs.getString("PRODNAME"),rs.getString("PRODSTATUS"),rs.getDouble("PRODSELLPRC"),rs.getDouble("PRODACQPRC"),rs.getInt("PRODQUANTITY"),rs.getString("ACQDATE"),rs.getString("EXPDATE")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return products;
    }
    public ArrayList<Product> sortA(String sortType)  //sorts records in ascending order
    {
        ArrayList<Product> products=new ArrayList<Product>();
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String query = "SELECT * FROM PRODREC ORDER BY " + sortType;
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                products.add(new Product(rs.getInt("PRODID"),rs.getString("PRODNAME"),rs.getString("PRODSTATUS"),rs.getDouble("PRODSELLPRC"),rs.getDouble("PRODACQPRC"),rs.getInt("PRODQUANTITY"),rs.getString("ACQDATE"),rs.getString("EXPDATE")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return products;  
    }
    public ArrayList<Product> sortB(String sortType)  //sorts records in descending order
    {
        ArrayList<Product> products=new ArrayList<Product>();
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String query = "SELECT * FROM PRODREC ORDER BY " + sortType + " DESC";
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                products.add(new Product(rs.getInt("PRODID"),rs.getString("PRODNAME"),rs.getString("PRODSTATUS"),rs.getDouble("PRODSELLPRC"),rs.getDouble("PRODACQPRC"),rs.getInt("PRODQUANTITY"),rs.getString("ACQDATE"),rs.getString("EXPDATE")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return products;  
    }
    
        public void createSellRec(int id, String name, int qty, double prc)  //creates a record of a sold product
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="INSERT INTO SELLREC VALUES(" + id+ ",'" + name+ "','" + qty+ "','" + prc+ "' )";
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Processed successfully!");
	}
	catch(SQLException se)
	{
            String msg="Cannot add!";
            JOptionPane.showMessageDialog(null,msg);		
	}
    }
    public void updateRec2(int prodid, int quantity)  //updates a specific record's quantity using ID
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="UPDATE PRODREC SET PRODQUANTITY = " + quantity + " WHERE PRODID = " + prodid;
            myStmt.executeUpdate(qry);
            myStmt.close();
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
        
    }
    public void deleteRec2(int oldProdid)  //deletes a specific sold product's record using ID
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="DELETE FROM SELLREC WHERE PRODID = " + oldProdid;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Reverted successfully!");
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    public int reqQty(int prodid) throws SQLException  //returns the quantity of a specific product using ID
    {
            int tempqty;
            getConnection();

            myStmt=myConn.createStatement();
            String query="SELECT PRODQUANTITY FROM PRODREC WHERE PRODID = " + prodid;
            ResultSet rs = myStmt.executeQuery(query);
            rs.next();
            tempqty = rs.getInt("PRODQUANTITY");
            rs.close();
            myStmt.close();
            return tempqty;
    }
    public ArrayList<SellProd> displaySellRec()  //returns all sold products records
    {
        ArrayList<SellProd> sellprods=new ArrayList<SellProd>();
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String query = "SELECT * FROM SELLREC";
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                sellprods.add(new SellProd(rs.getInt("PRODID"),rs.getString("PRODNAME"),rs.getDouble("PRODSELLPRC"),rs.getInt("PRODQUANTITY")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return sellprods;
    }
}
        
