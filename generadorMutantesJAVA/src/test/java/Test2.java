import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test2{

	@org.junit.Test
	public void test() {
		
double[] inputs={85.30296752602231,91.49948904409902,-50.18461883394496,-86.00739924139262,-68.13092720650182,63.10986916073665,-1.8166374159303729,87.48451944573134,25.219878303278293,-1.5714005239105973,-1.9042314201252566,-37.82077088080311,-83.25693117888994,34.60554800453275,73.062198448788,-88.3492854534837,-29.71223202772397,-57.95781490684924,-58.44398517125868,96.9935532983331,-51.814466305896545,56.75373329118244,43.34938650031248,7.4757530942147525,77.35614099347359,32.25830970570806,-16.31960174845058,-35.94403936155955,-53.388117651198975,-73.78018670006776,-73.07334637061481,-29.61750441570436,84.30386295121099,-97.2106050751245,65.30696994219699,3.323757998160957,72.07145191744269,73.98001258503419,33.115495767821585,34.423693149022625,63.83129147773312,-5.49211694006533,-51.113368523233845,68.12159940999845,6.446381712426998,58.17115155677385,91.37888416629363,-27.558812665668157,-6.010935213851852,-3.9638108118138007,73.28138500131195,82.31229360576796,-77.49422202248373,-82.7074583494};
int[] decision_inputs={1,2,3};
assertArrayEquals(new Programa(inputs,decision_inputs).get_result_bool(1,2),
				new Programa(inputs,decision_inputs).get_result_bool(1,2));
		assertArrayEquals(new Programa(inputs,decision_inputs).get_result_num(1,2),
				new Programa(inputs,decision_inputs).get_result_num(1,2));
}
}
