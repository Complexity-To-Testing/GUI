package Tests;

import businessLogic.BusinessLogic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessLogicTest1 {

    private void shouldGetPrice(int a, int b, int resultado){
        assertEquals(resultado, new BusinessLogic().getPrecio(a, b));
    }


    @Test
    public void shouldGetNormalPricingForOneItem(){
        shouldGetPrice(1, 1, 2);
    }

}
