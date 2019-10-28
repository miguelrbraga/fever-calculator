# fever-calculator

Calculator that detects whether a patient has fever or not. An instance of Patient needs to be created, passing five arguments: the age of the patient (Integer); the type of the reading - oral, armpit, rectal, ear (ReadingType); the value of the reading (Double); the unit used to measure the reading - celsius, kelvin, fahrenheit (TemperatureUnit); the objects available to be processed (TemperatureInterface array). When executing hasFever method on the instance of Patient, a boolean value should be returned: true if the patient has fever, false otherwise.

Classes explained:

OralReading, ArmpitReading, RectalReading and EarReading all implement TemperatureInterface. Within each of these four classes, the fever thresholds are defined as per the literature, based on the age of the patient and the reading.

The Detect class is the main, whereas Patient is the class which establishes the relationship between the user's input and the remaining classes.
