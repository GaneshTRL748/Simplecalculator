package calculator;
class Add extends Numbers{
	Add(double x,double y)
	{
		super(x,y);
	}
	@Override
	public void calculate()
	{
		out.println("AdditionResult:"+(this.num1+this.num2));
	}
}