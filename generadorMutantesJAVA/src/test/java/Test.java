import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test{

	@org.junit.Test
	public void test() {
		
double[] inputs={-1.0,0.0,1.0};
int[] decision_inputs={0,0,0,0,0,0,0,0,0,0,0};
assertArrayEquals(new Programa(inputs,decision_inputs).get_result_num(1,0),new Programa(inputs,decision_inputs).get_result_num(1,0),0);
		assertArrayEquals(new Programa(inputs,decision_inputs).get_result_bool(1,0),new Programa(inputs,decision_inputs).get_result_bool(1,0));

}
}
