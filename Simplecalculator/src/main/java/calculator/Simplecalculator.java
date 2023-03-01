package calculator;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Simplecalculator {
	static PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
	double getnum()
	{
   	 Scanner p=new Scanner(System.in);
   	 double num;
   	 try {
   		 num=p.nextDouble();
   		 return num;
   	 }
   	 catch(Exception e)
   	 {
   		 out.println("It be shoud number type");
   	    return getnum();
   	 }
	}
	String getchar()
	{
		Scanner p=new Scanner(System.in);
		char choice;
		try {
			choice =p.next().charAt(0);
			if(choice=='+'||choice=='/'||choice=='*'||choice=='-')
			{
				return Character.toString(choice);
			}
			else {
				throw new InputMismatchException("Invalid");
			}
			
		}
		catch (Exception e)
		{
			out.println(e);
			return getchar();
		}
	}
	public static void main(String[] args) {
      Simplecalculator b1=new Simplecalculator();
      
      double num1;
      double num2;
      char choice;
      while(true)
      {
    	  out.println("Enter the Number1 and Number2:");
    	  num1=b1.getnum();
    	  num2=b1.getnum();
          out.println("Enter the operator\n"+"Exit-0");
    	  choice=b1.getchar().charAt(0);
    	  switch(choice)
    	  {
	    	  case '0':
	    	  {
	    		  System.exit(0);
	    		  break;
	    	  }
    	     case '+':
    	     { 
    	    	    Numbers  a1=new Add(num1,num2);
    	    	    a1.calculate();
    	    	    break;
    	     }
    	     case '-':
    	     {

    	    	   Numbers a1=new Sub(num1,num2);
    	    	    a1.calculate();
    	    	    break;
    	     }
    	     case '*':
    	     {
    	    	 Numbers a1=new Mul(num1,num2);
    	    	 a1.calculate();
    	    	 break;
    	     }
    	     case '/':
    	     {
    	    	 Numbers a1=new Div(num1,num2);
    	    	 a1.calculate();
    	    	 break;
    	     }
    	     default:
    	     {
    	    	 out.println("Invalid Choice!!!!");
    	    	 break;
    	     }
    	  }
    	}
	}


}
