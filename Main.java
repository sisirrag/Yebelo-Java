import java.util.Scanner;
import java.io.*;
import java.sql.*;

class Main
{
    public static int calc(int x)
    {
            
        int s;
        int test=10;       

        do
        {
            x++;
            s=0;
            int n=x;
            
            int d=0;

            while(n>0)
            {
                d=n%10;
                s+=d;
                n=n/10;   
            }

            while(s>test)
            {
                test=test*test;
            }  
            
                  
            
        }while(s!=test);

        return x;
    }

    

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String categorycode=sc.next();

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sisir");
        Statement st=con.createStatement();

         ResultSet rs=st.executeQuery("select categorycode,value from fdb where categorycode='"+categorycode+"'");
            while(rs.next())
            {
                
                value=rs.getInt("value");
            }
            value=calc(value);
            
        st.executeUpdate("update fdb set value="+value+"where categorycode='"+categorycode+"'");

    }
}