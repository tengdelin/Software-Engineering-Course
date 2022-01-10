package test2.expression;

/**
 * Class to compute the derivative of an Expression. 
 * @author zhilinh
 *
 */
public class DerivativeExpression implements Expression {

	private final double deltaX = 1e-9;
	private Expression fn;
	private Variable independentVar;
	private double fnVal;
	/**
	 * 创建一个表达式，表示指定函数相对于指定变量的导数。
	 *
	 * @param fn 此表达式表示其导数的函数
	 * @param independent 与我们相关的变量
	 * differentiating
	 */
	public DerivativeExpression(Expression fn, Variable independent) {
		//throw new Exception("Need to be implemented！");
		this.fn=fn;
		this.independentVar=independent;
	}

	/**
	 * Method that returns the derivative of the Expression.
	 *
	 * @return returns the value of the Expression.
	 */
	@Override
	public double eval() {
		//throw new Exception("Need to be implemented！");
		double x=fn.eval();
		independentVar.store(independentVar.eval()+deltaX);
		double y=fn.eval();
		double ans=(y-x)/deltaX;
		return ans;
	}

}
