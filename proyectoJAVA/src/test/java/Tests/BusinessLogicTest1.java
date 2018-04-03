package Tests;

import businessLogic.BusinessLogic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessLogicTest1 {

    private void shouldGetPrice(int amount, boolean hasCoupon, int price){
        assertEquals(price, new BusinessLogic().getPrecio(amount, hasCoupon));
    }

    @Test
    public void shouldGetNormalPricingForOneItem(){
        shouldGetPrice(1, false, 17);
    }


}
