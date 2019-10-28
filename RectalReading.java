package feverdetector;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RectalReading implements TemperatureInterface {
	
	private static final Map<AgeRange, Double> celsiusThresholdsRectal;
	
	static {
		Map<AgeRange, Double> minTempFeverCelsiusRectal = new TreeMap<>();
		
		minTempFeverCelsiusRectal.put(AgeRange.YOUNGER_THAN_3, 38.0);
		minTempFeverCelsiusRectal.put(AgeRange.BETWEEN_3_AND_11, 38.0);
		minTempFeverCelsiusRectal.put(AgeRange.BETWEEN_11_AND_65, 38.1);
		minTempFeverCelsiusRectal.put(AgeRange.OVER_65, 37.3);
		
		celsiusThresholdsRectal = Collections.unmodifiableMap(minTempFeverCelsiusRectal);
	}

	@Override
	public ReadingType getReadingType() {
		return ReadingType.RECTAL;
	}

	@Override
	public boolean hasFever(AgeRange ageRange, double reading) {
		boolean feverIndicator = false;
		
		for (Map.Entry<AgeRange, Double> entry: celsiusThresholdsRectal.entrySet()) {
			if (ageRange == entry.getKey() && reading > entry.getValue()) {
				feverIndicator = true;
				break;
			}
		}
		
		return feverIndicator;
	}
	
}
