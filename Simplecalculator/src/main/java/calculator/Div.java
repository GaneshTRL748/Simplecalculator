package calculator;
class Div extends Numbers{

	public Div(double d, double e) {
		super(d, e);
	}

	@Override
	public void calculate() {
	
		out.println("DivisionResult:"+(this.num1/this.num2));	

	}
	
}