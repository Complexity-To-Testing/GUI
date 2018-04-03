package businessLogic;

public class BusinessLogic {
    public int getPrecio(int amount, boolean hasCoupon) {

        if (amount >= 20 || hasCoupon) {
            return amount * 15;
        }
        return  amount * 17;
    }
}
