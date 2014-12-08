import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class FormulaTest {

	@Test
	public void test() {
		Formula a = new Formula("a");
		Formula b = new Formula("b");
		a.and(b.or((new Formula("c")).not()));
		a.or(new Formula("d"));
		a.not();
		Map<String, Boolean> values = new HashMap<String, Boolean>();
		values.put("a", true);
		values.put("b", false);
		values.put("c", true);
		values.put("d", false);
		System.out.println(a.evaluate(values));
		System.out.println(a);
	}

}
