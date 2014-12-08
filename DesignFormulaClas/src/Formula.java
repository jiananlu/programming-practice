import java.util.*;

public class Formula {
	enum Operator {
		AND("&&"), OR("||");
		String label;
		Operator(String label) {
			this.label = label;
		}
		public String toString() {
			return this.label;
		}
	}
	
	List<Formula> formulas;
	List<Operator> operators;
	String label;
	boolean notFlag;
	
	public Formula(String label) {
		this.label = label;
		formulas = new ArrayList<Formula>();
		operators = new ArrayList<Operator>();
		formulas.add(this);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.label);
		for (int i = 0; i < operators.size(); i++) {
			Formula next = formulas.get(i+1);
			Operator op = operators.get(i);
			sb.append(" " + op.toString() + " ");
			String n = next.toString();
			
			if (next.operators.size()>0) {
				sb.append("(" + n + ")");
			} else {
				sb.append(n);
			}
			
		}
		String s = sb.toString();
		if (notFlag) {
			if (operators.size() >0) {
				s = "!(" + s + ")";
			} else {
				s = "!" + s;
			}
		}
		return s;
	}
	
	public boolean evaluate(Map<String, Boolean> values) {
		boolean res = values.get(formulas.get(0).label);
		for (int i = 0; i < operators.size(); i++) {
			Formula nextFormula = formulas.get(i+1);
			boolean next = nextFormula.evaluate(values);
			if (nextFormula.notFlag) {
				next = !next;
			}
			Operator op = operators.get(i);
			if (op == Operator.AND) {
				res = res && next;
			} else if (op == Operator.OR) {
				res = res || next;
			} else {
				// error
			}
		}
		
		return res;
	}
	
	public Formula and(Formula other) {
		formulas.add(other);
		operators.add(Operator.AND);
		return this;
	}
	
	public Formula or(Formula other) {
		formulas.add(other);
		operators.add(Operator.OR);
		return this;
	}
	
	public Formula not() {
		notFlag = !notFlag;
		return this;
	}
}