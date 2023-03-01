package calculator;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

abstract class Numbers{
	 PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
	 double num1;
	 double num2;
	protected Numbers(double d, double e) {
		this.num1=d;
		this.num2=e;
	}
	public abstract void calculate();
}
