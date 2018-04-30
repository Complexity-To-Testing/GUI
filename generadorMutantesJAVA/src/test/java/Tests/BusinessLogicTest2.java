package Tests;

import businessLogic.BusinessLogic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessLogicTest2 {

    private void shouldGetPrice(int a, int b, int resultado){
        assertEquals(resultado, new BusinessLogic().getPrecio(a, b));
    }
    private void shouldGetPrice1(int a, int b, int resultado){
        assertEquals(resultado, new BusinessLogic().getPrecio1(a, b));
    }

    @Test
    public void shouldGetNormalPricingForOneItem(){
        shouldGetPrice(1, 1, 2);
    }
    @Test
    public void shouldGetNormalPricingForOneItem1(){
        shouldGetPrice1(1, 1, 2);
    }
}
