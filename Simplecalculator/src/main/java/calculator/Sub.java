package calculator;
class Sub extends Numbers{
	Sub(double x,double y)
	{
		super(x,y);
	}
	@Override
	public void calculate() {
		out.println("SubractionResult:"+(this.num1-this.num2));
	}
}
