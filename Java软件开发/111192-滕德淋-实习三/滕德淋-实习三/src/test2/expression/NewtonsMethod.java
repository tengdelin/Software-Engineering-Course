package test2.expression;

/**
 * Class to find a zero of a function using Newton's method
 * @author zhilinh
 *
 */
public class NewtonsMethod {

	/**
	 * 使用牛顿法以 approxZero 作为初始估计值返回指定函数的零。
	 *
	 * @param fn 要找到其零的函数
	 * @param x 函数的自变量
	 * @param approxZero 函数零的初始逼近
	 * @param tolerance f（返回值）必须接近零
	 * @return a value x for which f(x) is "close to zero" (<= tolerance)
	 */
	public double zero(Expression fn, Variable x, double approxZero, double tolerance) {

		// 继续循环以找到零时的值之间的差异
		// 变量 x 和 approxZero 大于容差。
		x.store(approxZero);
		DerivativeExpression ffn=new DerivativeExpression(fn,x);
		double res=approxZero- fn.eval()/ ffn.eval();
		while (Math.abs(res-approxZero)>=tolerance){
			approxZero=res;
			x.store(res);
			res=approxZero- fn.eval()/ ffn.eval();
		}
		//throw new Exception("Need to be implemented！");
		return res;
	}

}
