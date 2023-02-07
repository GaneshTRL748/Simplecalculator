package calculator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
abstract class Numbers{
	Logger l= Logger.getLogger("com.api.jar");
	 double num1;
	 double num2;
	public Numbers(double d, double e) {
		this.num1=d;
		this.num2=e;
	}
	public abstract void calculate();
}
class Add extends Numbers{
	Add(double x,double y)
	{
		super(x,y);
	}
	@Override
	public void calculate()
	{
		l.log(Level.INFO,()->"Result:"+(this.num1+this.num2));
	}
}
class Sub extends Numbers{
	Sub(double x,double y)
	{
		super(x,y);
	}
	@Override
	public void calculate() {
		l.log(Level.INFO,()->"Result:"+(this.num1-this.num2));
	}
}
class Mul extends Numbers{

	public Mul(double d, double e) {
		super(d, e);
	}

	@Override
	public void calculate() {
		l.log(Level.INFO,()->"Result:"+(this.num1*this.num2));	
	}
	
}
class Div extends Numbers{

	public Div(double d, double e) {
		super(d, e);
	}

	@Override
	public void calculate() {
	
		l.log(Level.INFO,()->"Result:"+(this.num1/this.num2));	

	}
	
}
public class Simplecalculator {
	static Logger l= Logger.getLogger("com.api.jar");
	public static void main(String[] args) {
      Scanner p=new Scanner(System.in);
      double num1;
      double num2;
      char choice;
      while(true)
      {
    	  l.info("Enter the Number1 and Number2:");
    	  num1=p.nextDouble();
    	  num2=p.nextDouble();
          l.info("Enter the operator\n"+"Exit-0");
    	  choice=p.next().charAt(0);
    	  switch(choice)
    	  {
	    	  case '0':
	    	  {
	    		  System.exit(0);
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
    	    	 l.info("Invalid Choice!!!!");
    	     }
    	  }
    	}
	}


}
