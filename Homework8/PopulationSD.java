class PopulationSD implements StandardDeviation {
	
	double average = 0;
	double sdcalc = 0;
	
	//This class contains 2 methods, one to calculate the average of an arrary of integers and one to calculate the standard deviation of those integers.
	//Both methods receive an integer array and return the results of the calculation as doubles.
	public double calculateAverage(int myRI[])
	{
		for (int x : myRI) {
			
			this.average += x;
		
		}
		return this.average /= myRI.length;
	}

	public double calculateSD(int myRI[])
	{
		for (int y : myRI) {
			
			this.sdcalc += Math.pow((y - this.average), 2);
		
		}
		return Math.sqrt(this.sdcalc/myRI.length);
	}

}
