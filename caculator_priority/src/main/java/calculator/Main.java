package calculator;
import java.util.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
class Calculator{
	static PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
	String str;
    String[] exp;
    char[] stack;
    int index=-1;
    int ansindex=0;
    String[] ans;
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    int[] ansstack;
    int peek=-1;
    void insert(String temp)
    {
        ansstack[++peek]=Integer.parseInt(temp);
    }
    int getnum()
    {
        return ansstack[peek--];
    }
    void display()
    {
        out.print(ansstack[peek]);
    }
}
class Evaluate extends Calculator
{
    void evaluate(char temp,Evaluate a1)
    {
        int x;
        int y;
        int ans;
        if(temp=='+')
        {
            x=a1.getnum();
            y=a1.getnum();
            ans=x+y;
            a1.ansstack[++a1.peek]=ans;
        }
        else if(temp=='-')
        {
            x=a1.getnum();
            y=a1.getnum();
            ans=y-x;
            a1.ansstack[++a1.peek]=ans;
        }
        else if(temp=='*')
        {
            x=a1.getnum();
            y=a1.getnum();
            ans=x*y;
            a1.ansstack[++a1.peek]=ans;
        }
        else if(temp=='/')
        {
            x=a1.getnum();
            y=a1.getnum();
            ans=y/x;
            a1.ansstack[++a1.peek]=ans;
        }
        else{
            
            x=a1.getnum();
            y=a1.getnum();
            ans=(int)Math.pow(y,x);
            a1.ansstack[++a1.peek]=ans;
        }
    }
}
public class Main extends Calculator
{
    
    int top=-1;
    void operation(char temp)
    {
        if(this.top==-1)
        {
            push(temp);
        }
        else if(temp=='(')
        {
            push(temp);
        }
        else if(temp==')')
        {
            brackoperation();
        }
        else if(this.stack[this.top]==temp)
        {
            associtivity(temp);
        }
        else{
            prescheck(temp);
        }
    }
    void brackoperation()
    {
        if(top>=0){
        while(this.stack[this.top]!='(')
        {
            pop();
        }
          top--;
        }
    }
    void push(char temp)
    {
        this.top++;
        this.stack[this.top]=temp;
    }
    void associtivity(char temp)
    {
        if(temp=='^')
        {
            push(temp);
        }
        else{
            pop();
            operation(temp);
        }
    }
    void prescheck(char temp)
    {
        if(this.stack[this.top]=='(')
        {
            push(temp);
        }
        else if(this.map.get(temp)>this.map.get(this.stack[this.top]))
        {
            push(temp);
        }
        else{
            pop();
            operation(temp);
        }
    }
    void pop()
    {
        if(top>=0){
        	ans[ansindex++]=Character.toString(this.stack[this.top]);
           top--;
        }
    }
    String getexp()
    {
    	Scanner p=new Scanner(System.in);
    	String exp=p.next();
    	for(int i=0;i<exp.length();i++)
    	{
    		if(exp.charAt(i)!='+'&&false==Character.isDigit(exp.charAt(i))&&exp.charAt(i)!='-'&&exp.charAt(i)!='*'&&exp.charAt(i)!='/'&&
    				exp.charAt(i)!='('&&exp.charAt(i)!=')'&&exp.charAt(i)!='^')
    		{
    			out.print("It should be number type");
    			return getexp();
    		}
    	}
    	return exp;
    }
    void split()
    {
    	int flag=0;
        for(int i=0;i<str.length();i++){
                    if(Character.isDigit(str.charAt(i)))
                    {
                        if(flag==0){
                           exp[++index]=Character.toString(str.charAt(i));
                           flag=1;
                        }
                        else{
                            exp[index]=exp[index]+str.charAt(i);
                        }
                    }
                    else{
                        exp[++index]=Character.toString(str.charAt(i));
                        flag=0;
                    }
        }
    }
	public static void main(String[] args) {
	    Main a1=new Main();
	    out.print("Enter the expression for evaluation:");
	    a1.str=a1.getexp();
	    a1.map.put('(',4);
	    a1.map.put(')',4);
	    a1.map.put('^',3);
	    a1.map.put('/',2);
	    a1.map.put('*',2);
	    a1.map.put('+',1);
	    a1.map.put('-',1);
	    a1.exp=new String[a1.str.length()];
	    a1.split();
	    a1.stack=new char[a1.index];
	    a1.ans=new String[a1.index+1];
	    for(int i=0;i<=a1.index;i++)
	    {
	    	if(a1.exp[i].equals("+")||a1.exp[i].equals("-")||a1.exp[i].equals("*")||
	    			a1.exp[i].equals("/")||a1.exp[i].equals("^")||a1.exp[i].equals("(")||a1.exp[i].equals(")"))
	    	{
	    		 a1.operation(a1.exp[i].charAt(0));
	    	}
	    	else {
	    		a1.ans[a1.ansindex++]=a1.exp[i];
	    	}
	    }
	    for(int i=a1.top;i>=0;i--)
	    {
	        a1.pop();
	    }
	   Evaluate a2=new Evaluate();
	    a2.ansstack=new int[a1.ansindex];
	    for(int i=0;i<a1.ansindex;i++)
	    {
	        if(a1.ans[i].equals("+")||a1.ans[i].equals("-")||a1.ans[i].equals("*")||
	    			a1.ans[i].equals("/")||a1.ans[i].equals("^"))
	        {
	        	a2.evaluate(a1.ans[i].charAt(0), a2);
	        }
	        else {
	        	a2.insert(a1.ans[i]);
	        }
	    }
	    a2.display();
	}
}
