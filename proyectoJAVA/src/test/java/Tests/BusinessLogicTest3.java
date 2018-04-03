package Tests;

import businessLogic.BusinessLogic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessLogicTest3 {

    private void shouldGetPrice(int amount, boolean hasCoupon, int price) {
        assertEquals(price, new BusinessLogic().getPrecio(amount, hasCoupon));
    }

    @Test
    public void shouldGetDiscountPricingByAmount() {
        shouldGetPrice(100, false, 1500);
    }
}