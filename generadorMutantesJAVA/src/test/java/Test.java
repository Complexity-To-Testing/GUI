import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test{

	@org.junit.Test
	public void test() {
		
double[] inputs={-10.0,-9.0,-8.0,-7.0,-6.0,-5.0,-4.0,-3.0,-2.0,-1.0,0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
int[] decision_inputs={0,0,0,0,0,0,0,0,0,0,0};
assertArrayEquals(new Programa(inputs,decision_inputs).get_result_num(1,0),new Programa(inputs,decision_inputs).get_result_num(1,0),0);
		assertArrayEquals(new Programa(inputs,decision_inputs).get_result_bool(1,0),new Programa(inputs,decision_inputs).get_result_bool(1,0));

}
}
