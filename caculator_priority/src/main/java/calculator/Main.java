package calculator;

import java.util.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
class Calculator{
	static PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
    String exp;
    char[] stack;
    StringBuilder ans=new StringBuilder();
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    int[] ansstack;
    int peek=-1;
    void insert(char temp)
    {
        ansstack[++peek]=temp-'0';
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
            ans=x-y;
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
          ans.append(this.stack[this.top]);
           top--;
        }
    }
	public static void main(String[] args) {
	    Main a1=new Main();
	    Scanner p=new Scanner(System.in);
	    out.print("Enter the expression for evaluation:");
	    a1.exp=p.next();
	    a1.map.put('(',4);
	    a1.map.put(')',4);
	    a1.map.put('^',3);
	    a1.map.put('/',2);
	    a1.map.put('*',2);
	    a1.map.put('+',1);
	    a1.map.put('-',1);
	    a1.stack=new char[a1.exp.length()];
	    for(int i=0;i<a1.exp.length();i++)
	    {
	        if(a1.exp.charAt(i)=='*'||a1.exp.charAt(i)=='/'||a1.exp.charAt(i)=='+'||
	        a1.exp.charAt(i)=='-'||a1.exp.charAt(i)=='('||a1.exp.charAt(i)==')'||a1.exp.charAt(i)=='^'){
	           
	              a1.operation(a1.exp.charAt(i));
	        }
	        else{
	            a1.ans.append(a1.exp.charAt(i));
	        }
	    }
	    for(int i=a1.top;i>=0;i--)
	    {
	        a1.pop();
	    }
	    Evaluate a2=new Evaluate();
	    a2.ansstack=new int[a1.ans.length()];
	    for(int i=0;i<a1.ans.length();i++)
	    {
	        if(a1.ans.charAt(i)=='+'||a1.ans.charAt(i)=='-'||
	        a1.ans.charAt(i)=='*'||a1.ans.charAt(i)=='/'||a1.ans.charAt(i)=='^')
	        {
	            a2.evaluate(a1.ans.charAt(i),a2);
	           
	        }
	        else{
	            a2.insert(a1.ans.charAt(i));
	        }
	    }
	    a2.display();
	}
}
