package test2.expression;

/**
 * 
 * Class to implement absolute value to an Expression.
 * @author zhilinh
 *
 */
public final class AbsoluteValueExpression implements Expression {

	private Expression value;
	
	/**
	 * Public constructor that assigns a value to the
	 * instance Expression.
	 * 
	 * @param value of an Expression which needs to get
	 * an absolute value.
	 */
	public AbsoluteValueExpression(Expression value) {
		this.value = value;
	}
	
	/**
	 * toString method that returns the Expression with
	 * absolute value.
	 */
	@Override
	public String toString() {
//		throw new Exception("Need to be implemented！");
		return ""+Math.abs(value.eval());
	}
	
	/**
	 * Method that returns the value of the Expression.
	 * 
	 * @return returns the value of the Expression.
	 */
	public double eval() {
//		throw new Exception("Need to be implemented！");
		return Math.abs(value.eval());
	}

}
