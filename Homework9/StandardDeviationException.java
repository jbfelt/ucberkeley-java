class StandardDeviationException extends Exception {
	
	//This is the custom exception class which displays those numbers to the end user where the Standard Deviation is greater than 1
	
	int outlier;
	
	StandardDeviationException(int i)
	{
		this.outlier = i;
        System.out.println("The number " + this.outlier + " exceeds 1 Standard Deviation per the normal curve and should be reviewed for accuracy."); 
	}
}