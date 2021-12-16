import java.util.Scanner;
import java.io.*;
import java.sql.*;

class Main
{
    public static int calc(int x)
    {
            
        int s,ss;
        boolean test=false;       

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
            ss=0;
            while(s>0)
            {
                d=s%10;
                ss+=d;
                s=s/10;
            }              
                  
            
        }while(ss!=1);

        return x;
    }

    

    public static void main(String args[])
    {
        int value=0;
        Scanner sc=new Scanner(System.in);
        String categorycode=sc.next();

        
         try
         {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","5656");
            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("select value from fdb where categorycode='"+categorycode+"'");
            
            while(rs.next())
            {
                
                value=rs.getInt("value");  
                
            }
            System.out.println("old:"+value+"");
            value=calc(value);
            System.out.println("new:"+value+"");
            
            
            st.executeUpdate("update fdb set value="+value+"where categorycode='"+categorycode+"'");
            con.close();
         }
         catch(Exception e)
         {
             System.out.println("Invalid Input");
         }

         37-> 3+7->10 ->1+0 ->1
         46-> 4+6->10 ->1+0 ->1
         127->1+2+7->10 ->1
         136 -> 

            
        



        
        
        

    }
}