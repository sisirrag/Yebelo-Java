import java.util.Scanner;

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
        int input=sc.nextInt(); 
        System.out.println(calc(input));    

    }
}