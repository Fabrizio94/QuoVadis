package quovadis.model;



public class QuoVadisSingleton {
	
	private static QuoVadis quoVadis;
	
	private QuoVadisSingleton() {
		
	}

	public static QuoVadis getInstance() {
		if(quoVadis == null) {
			quoVadis = new QuoVadis();
		}
		return quoVadis;
	}
}

