package feverdetector;

public class Patient {
	
	private int age; // Age of the patient
	private ReadingType readingType; // Type of the reading: oral, armpit, rectal, ear
	private double reading; // Value of the reading
	private TemperatureUnit temperatureUnit; // Unit used to measure the reading
	private TemperatureInterface[] readingObjects; // Available objects
	
	public Patient(int age, ReadingType readingType, double reading, 
			TemperatureUnit temperatureUnit, TemperatureInterface[] readingObjects) {
		this.age = age;
		this.readingType = readingType;
		this.reading = reading;
		this.temperatureUnit = temperatureUnit;
		this.readingObjects = readingObjects;
	}
	
	public boolean hasFever() {
		
		double temperatureCelsius = 0;
		boolean feverIndicator = false;
		AgeRange ageRange = AgeRange.YOUNGER_THAN_3;
		
		if (temperatureUnit != TemperatureUnit.CELSIUS) {
			if (temperatureUnit == TemperatureUnit.FAHRENHEIT) {
				temperatureCelsius = (reading - 32) * (5/9);
			} else if (temperatureUnit == TemperatureUnit.KELVIN) {
				temperatureCelsius = reading - 273.15;
			}
		} else {
			temperatureCelsius = reading;
		}
		
		if (age < AgeRange.YOUNGER_THAN_3.getMaximumAge()) {
			ageRange = AgeRange.YOUNGER_THAN_3;
		} else if (age >= AgeRange.BETWEEN_3_AND_11.getMinimumAge() &&
				age < AgeRange.BETWEEN_3_AND_11.getMaximumAge()) {
			ageRange = AgeRange.BETWEEN_3_AND_11;
		} else if (age >= AgeRange.BETWEEN_11_AND_65.getMinimumAge() &&
				age < AgeRange.BETWEEN_11_AND_65.getMaximumAge()) {
			ageRange = AgeRange.BETWEEN_11_AND_65;
		} else if (age >= AgeRange.OVER_65.getMinimumAge()) {
			ageRange = AgeRange.OVER_65;
		}
		
		for (TemperatureInterface object: readingObjects) {
			if (readingType == object.getReadingType()) {
				feverIndicator = object.hasFever(ageRange, temperatureCelsius);	
			}
		}
		
		return feverIndicator;
	}

	public int getAge() {
		return age;
	}

	public ReadingType getReadingType() {
		return readingType;
	}

	public double getReading() {
		return reading;
	}

	public TemperatureUnit getTemperatureUnit() {
		return temperatureUnit;
	}

}
