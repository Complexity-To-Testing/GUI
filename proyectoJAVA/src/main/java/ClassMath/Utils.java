package ClassMath;



public class Utils {
		
	// Returns random between [ min, max )
		public static double getRandomArbitrary(int min, int max) {
			return Math.random() * (max - min) + min;
		}
	
}