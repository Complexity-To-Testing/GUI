import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test1{

	@org.junit.Test
	public void test() {
		
double[] inputs={1.0,2.0,3.0,4.0,5.0,6.0,34.0,43.0,43.0,34.0,5.0,423.0,54.0,65.0,756.0,867.0,654.0,243.0,132.0,345.0,756.0,876.0};
int[] decision_inputs={0,1};
assertArrayEquals(new Programa(inputs,decision_inputs).get_result_bool(1,5),
				new Programa(inputs,decision_inputs).get_result_bool(1,5));
		assertArrayEquals(new Programa(inputs,decision_inputs).get_result_num(1,5),
				new Programa(inputs,decision_inputs).get_result_num(1,5));
}
}
