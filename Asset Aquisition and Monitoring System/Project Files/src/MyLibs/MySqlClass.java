
package MyLibs;

import MyLibs.MyOffices.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


//Connect to Database
public class MySqlClass {
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    String user = "root";
    String pass = "122";
    
    IOffice office;
    OfficeFactory officeFactory;

    public void getConnection()
    {
        try {
            //Connect to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eq_db_eq_table?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
        }catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}  
    }      
    
    public void createTable()
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();	
            String qry="CREATE TABLE STUDREC(EQ_NUM INT, EQ_NAME VARCHAR(32), EQ_CONDITION VARCHAR(30), OFFICE INT, PRIMARY KEY(EQ_NUM), FOREIGN KEY (OFFICE) REFERENCES office_db(office_id))";		
            myStmt.executeUpdate(qry);
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    //Add Query
    public void AddRow(Equipment equipment)
    {
        getConnection();
        int countFac;
        int countDean;
        int countSun;
        try{
            myStmt=myConn.createStatement();                                        //Initialize query statement
            String query = "SELECT Count(*) from eq_table where office = 1";        //Query to get total number of items in table whose office has a value of 1
            ResultSet rs = myStmt.executeQuery(query);                              //Assign result value to rs
            if (rs.next());
            countFac = rs.getInt(1);                                                //Assign value in rs to countFac which is the number of items in table whose office is Faculty
            query = "SELECT Count(*) from eq_table where office = 0";               //Query to get total number of items in table whose office has a value of 0
            rs = myStmt.executeQuery(query);                                        //Assign result value to rs
            if (rs.next());
            countDean = rs.getInt(1);                                               //Assign value in rs to countFac which is the number of items in table whose office is Dean's
            query = "SELECT Count(*) from eq_table where office = 2";               //Query to get total number of items in table whose office has a value of 2
            rs = myStmt.executeQuery(query);                                        //Assign result value to rs
            if (rs.next());
            countSun = rs.getInt(1);                                                //Assign value in rs to countFac which is the number of items in table whose office is Sun&Moon
            
            
            switch(equipment.getOffice().OfficeNum()){
                case 0:
                    if (countDean <= 4){                                            //Checks and adds equipment to the table if the number of equipments in Dean's office is less than 5
                        String qry="INSERT INTO eq_table VALUES(" + equipment.getEQNum()+ ",'" + equipment.getEQName()+ "','" + equipment.getEQCondition()+ "','" + equipment.getOffice().OfficeNum()+"')";
                        myStmt.executeUpdate(qry);
                        myStmt.close();
                        JOptionPane.showMessageDialog(null,"Added successfully!");   
                        break;
                    }else{
                    JOptionPane.showMessageDialog(null, "Full");
                    break;}
                case 1:
                     if (countFac <= 4){                                             //Checks and adds equipment to the table if the number of equipments in Faculty office is less than 5
                        String qry="INSERT INTO eq_table VALUES(" + equipment.getEQNum()+ ",'" + equipment.getEQName()+ "','" + equipment.getEQCondition()+ "','" + equipment.getOffice().OfficeNum()+"')";
                        myStmt.executeUpdate(qry);
                        myStmt.close();
                        JOptionPane.showMessageDialog(null,"Added successfully!"); 
                        break;
                    }else{
                    JOptionPane.showMessageDialog(null, "Full");
                    break;}
                case 2:
                    if (countSun <= 4){                                              //Checks and adds equipment to the table if the number of equipments in Sun&Moon office is less than 5
                        String qry="INSERT INTO eq_table VALUES(" + equipment.getEQNum()+ ",'" + equipment.getEQName()+ "','" + equipment.getEQCondition()+ "','" + equipment.getOffice().OfficeNum()+"')";
                        myStmt.executeUpdate(qry);
                        myStmt.close();
                        JOptionPane.showMessageDialog(null,"Added successfully!");   
                        break;
                    }else{
                    JOptionPane.showMessageDialog(null, "Full");                    //Inform user that the office is already full and cannot take in more equipment
                    break;}
                default:
                    JOptionPane.showMessageDialog(null, "Full");
                    break;
                        
            }
       
	}
	catch(SQLException se)
	{
            String msg="Cannot add. Equipment" + equipment.getEQNum()+ " already exists!"; //Inform user that the equipment is already in the table
            JOptionPane.showMessageDialog(null,msg);		
	}
    }
    
    //Update Query
    public void EditRow(Equipment equipment, int oldEQnum)
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();                                        //Initialize Query Statement 
                                                                                    //Updates the selected record in the table
            String qry="UPDATE eq_table SET eq_ID = " + equipment.getEQNum()+ ", eq_Name = '" + equipment.getEQName()+ "' , eq_Condition = '" + equipment.getEQCondition()+ "' , Office = '" + equipment.getOffice().OfficeNum()+ "' WHERE eq_ID = " + oldEQnum;
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Updated successfully!");            //Informs user that the record has been updated
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    //Delete Query
    public void DeleteRow(int oldEQnum)
    {
        getConnection();
        try{
            myStmt=myConn.createStatement();                                         //Initialize Query Statement
            String qry="DELETE FROM eq_table WHERE eq_ID = " + oldEQnum;             //Deletes the selected record from the table
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null,"Deleted successfully!");            //Informs user that the record has been deleted from the table
	}
	catch(SQLException se)
	{
            System.out.println(se.getMessage());			
	}
    }
    
    //Get all records from table  
    public ArrayList<Equipment> ShowRec()
    {
        ArrayList<Equipment> equipment=new ArrayList<Equipment>();                  //Create equipment arraylist
        
        getConnection();
        try{
            myStmt=myConn.createStatement();                                        //Initialize Query Statement
            String query = "SELECT * FROM eq_table";                                //Selects all records from table
	    ResultSet rs = myStmt.executeQuery(query);                              

	    while(rs.next())
            {
                officeFactory = new OFactoryChoices();                              //Factory pattern to create office object 
                office=officeFactory.returnOffice(rs.getInt("Office"));
                equipment.add(new Equipment(rs.getInt("eq_ID"),rs.getString("eq_Name"),rs.getString("eq_Condition"), office)); //Add equipment object to arraylist
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return equipment;
    }
        //Get all equipment from table that needs to be purchased
        public ArrayList<Equipment> ShowPur()
    {
        //Declarations
        String lost = "Lost";
        String rep = "For Replacement";
        IOffice office;
        OfficeFactory officeFactory;
        ArrayList<Equipment> equipment=new ArrayList<Equipment>();
        
        getConnection();
        try{
            myStmt=myConn.createStatement();                                    
            String query = "SELECT * FROM eq_table where eq_Condition  = '" + lost +"' or eq_Condition = '" + rep +"'"; //Selects all equipment records from table whose condition is lost or for replacement
	    ResultSet rs = myStmt.executeQuery(query);

	    while(rs.next())
            {
                officeFactory = new OFactoryChoices();                              //Factory pattern to create office object
                office=officeFactory.returnOffice(rs.getInt("Office"));
                equipment.add(new Equipment(rs.getInt("eq_ID"),rs.getString("eq_Name"),rs.getString("eq_Condition"), office)); //Add equioment object to arraylist
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException sex)
	{
            System.out.println(sex.getMessage());
	}
        return equipment;
    }
       
    
}
