package burlap.oomdp.core;

/**
 * @author James MacGlashan.
 */
public class VariableRange {
	public double lower;
	public double upper;

	public VariableRange() {
	}

	public VariableRange(double lower, double upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public double span(){
		return upper - lower;
	}

	public double norm(double d){
		return (d - lower) / this.span();
	}
}
