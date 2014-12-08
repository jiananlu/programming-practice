import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg0 - arg1;
	}
	
}

public class StdoutOutputStreamTest {

	@Test
	public void test() {
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(0);
		input1.add(2);
		input1.add(4);
		input1.add(6);
		
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(1);
		input2.add(3);
		input2.add(5);
		input2.add(8);
		
		InputStream<Integer> in1 = new ArrayInputStream<Integer>(input1);
		InputStream<Integer> in2 = new ArrayInputStream<Integer>(input2);
		List<InputStream<Integer>> inputs = new ArrayList<InputStream<Integer>>();
		inputs.add(in1);
		inputs.add(in2);
		
		OutputStream<Integer> output = new StdoutOutputStream<Integer>();
		
		Merger<Integer> merger = new Merger<Integer>();
		merger.merge(inputs, output, new IntegerComparator());
	}

}
