package calculator;
class Mul extends Numbers{

	public Mul(double d, double e) {
		super(d, e);
	}

	@Override
	public void calculate() {
		out.println("MultiplicationResult:"+(this.num1*this.num2));	
	}
	
}