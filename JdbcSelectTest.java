import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 import java.util.Scanner;
// JDK 1.7 and above
public class JdbcSelectTest {
    static String title;// Save as "JdbcSelectTest.java"
   public  void main() {
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ipconv?useSSL=false", "myuser", "pqyn8565");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
         // Step 2: Allocate a 'Statement' object in the Connection
         
      ) {
         // Step 3: Execute a SQL SELECT query, the query result
         //  is returned in a 'ResultSet' object.
         Scanner sc=new Scanner(System.in);  
         System.out.println("enter 4 numbers");
         int a=fin.z1;
         int b=fin.z2;
         int c=fin.z3;
         int d=fin.z4;
          PreparedStatement pst = conn.prepareStatement("CALL IPCONVERTERREV11(?,?,?,?,@AW)");
          pst.setInt(1,a);
          pst.setInt(2,b);
          pst.setInt(3,c);
          pst.setInt(4,d);
          
         //String strSelect = "CALL IPCONVERTERREV1(1,1,1,1,@AW)";
        // System.out.println("The SQL query is: " + strSelect); // Echo For debugging
        // System.out.println();
 
         ResultSet rset = pst.executeQuery();
 
         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
         //  For each row, retrieve the contents of the cells with getXxx(columnName).
         System.out.println("The records selected are:");
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            title = rset.getString("ASS2");
          //  double price = rset.getDouble("price");
           // int    qty   = rset.getInt("qty");
           // System.out.println(title);
            ++rowCount;
         }
         System.out.println("Total number of records = " + rowCount);
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources
   }
}