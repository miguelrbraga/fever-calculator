package feverdetector;

public class Detect {

	public static void main(String[] args) {
		
		TemperatureInterface[] readingObj = new TemperatureInterface[] {
				new OralReading(), new RectalReading(),
				new ArmpitReading(), new EarReading()
		};
		
		Patient patient1 = new Patient(2,ReadingType.EAR,40,TemperatureUnit.CELSIUS,readingObj);
		System.out.println(patient1.hasFever());
		
		Patient patient2 = new Patient(65,ReadingType.ORAL,36.9,TemperatureUnit.CELSIUS,readingObj);
		System.out.println(patient2.hasFever());
		
		Patient patient3 = new Patient(10,ReadingType.ARMPIT,310.05,TemperatureUnit.KELVIN,readingObj);
		System.out.println(patient3.hasFever());
		
		Patient patient4 = new Patient(14,ReadingType.RECTAL,100.49,TemperatureUnit.FAHRENHEIT,readingObj);
		System.out.println(patient4.hasFever());

	}

}
