class SampleSD implements StandardDeviation {
	
	double average = 0;
	double sdcalc = 0;
	int sampleCounter = 0;
	
	//This class is identical to the PopulationSD class except that the methods have an "if" condition to only select the even integers.
	//The even check is use to select only a sample of the array of integers.
	public double calculateAverage(int myRI[])
	{
		for (int x : myRI) {
			
			//Select only the even elements of the array to take a sample of the population
			if (x % 2 == 0) {
				
				this.average += x;
				
				sampleCounter++;
				
			}
		}
		return this.average /= sampleCounter;
	}
	//The Standard Deviation equation for the sample differs from the SD equation for the population by changing the denominator to "n-1".
	public double calculateSD(int myRI[])
	{
		for (int y : myRI) {
			
			if (y % 2 == 0) {
				
				this.sdcalc += Math.pow((y - this.average), 2);
				
			}
		
		}
		return Math.sqrt(this.sdcalc/(myRI.length - 1));   //for n-1 of the population (aka Bessel's Correcion in statistics).
		
	}

}
