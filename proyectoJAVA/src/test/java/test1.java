import static org.junit.Assert.*;

import java.util.ArrayList;

public class test1{

	@org.junit.Test
	public void test() {
		
double[] inputs={1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
assertArrayEquals(new C1(inputs).get_result_num(),new C1(inputs).get_result_num(),0);
		assertArrayEquals(new C1(inputs).get_result_bool(),new C1(inputs).get_result_bool());

}
}
