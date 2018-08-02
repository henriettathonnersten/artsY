package artsYcode;

public class Postage {
	
	public int calculatePostage(double height, double width, double depth, double weight) {
		int postage = 0;
		
		int deliveryWeight = getWeightInGrams(weight);
	
		if (deliveryWeight <= 750) {
			
			if (height <= 24 && width <= 16.5 && depth <= 0.5) {
				
			}
		}
		
		
		
		
		
		
		return postage;
	}
	
	public int getWeightInGrams(double weight) {
		return (int) (weight * 100);
	}
	
}
