import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test{

	@org.junit.Test
	public void test() {
		
double[] inputs={1.0};
assertArrayEquals(new Programa(inputs).get_result_num(),new Programa(inputs).get_result_num(),0);
		assertArrayEquals(new Programa(inputs).get_result_bool(),new Programa(inputs).get_result_bool());

}
}
