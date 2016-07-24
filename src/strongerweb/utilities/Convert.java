package strongerweb.utilities;

public class Convert {
	public enum Weight {
		pounds (1),
		kilograms (0.453592);
		
		private final double relativeToPounds;
		
		Weight(double relativeToPounds) {
			this.relativeToPounds = relativeToPounds;
		}
		
		public double toKilograms() {
			return relativeToPounds;
		}
	}
}
