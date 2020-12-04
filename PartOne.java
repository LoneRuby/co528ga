//Part 1, using a search algorithm trying to reach the best precision up to E-16
//Runtime : <1s for 20
//Fitness : 0, perfect

import java.lang.Math;

class PartOne {

	public static double[] getSolOne(int solSize) {
		long startT=System.currentTimeMillis(); //Get the starting time for maximum time allowed
		long currentT = 0; //Make the current time value
		double[] sol1= new double[solSize]; //Array we are going to return
		for(int j=0; j<solSize;j++){sol1[j] = 0;} //Fill the array with empty values
		int op = 0; //Position of the array we're editing
		long time = 25000; //25000 = 25 seconds //Maximum time allowed for this part
		while((startT + time) > currentT) { //Check if we are in Allowed time
			long startStepT=System.currentTimeMillis(); //Time at start of step
			double preDeg = 1; //Precision degree
			double bestFitness = 9999999; //Best fitness
			double bestValue = 9999999; //Best value for fitness
			double cacheValue = 0; //Value in edition
			long unaSecunda = startStepT + (time / solSize) - currentT; //Definition of time for one step
			while(unaSecunda > 0) { //Greedy algorithm while we have time left
				double minCacheValue = cacheValue + (preDeg * -10); //Minimum value we're gonna search
				double maxCacheValue = cacheValue + (preDeg * 10); //Maximum value we're gonna search
				cacheValue = minCacheValue; //Start at the first value
				boolean preDegUp = false; //No need to increase precision degree
				while(!preDegUp) { //Check for each value
					sol1[op] = cacheValue;
					if(Assess.getTest1(sol1) < bestFitness) { //Try and succeed or fail
						bestFitness = Assess.getTest1(sol1); //Save the fitness if we succeed
						bestValue = cacheValue; //Save the value if we succeed
						//System.out.println("New fitness:" + bestFitness); //Debug value : Know when a better fitness has been found
						//System.out.println("New value at " + op + ":" + bestValue); //Debug value : Know which value has this better fitness
						//System.out.println(); //Debug : Cleanliness
					}
					cacheValue = cacheValue + preDeg;// Adding the precision degree
					cacheValue = cacheValue / preDeg;  //Making the number clean Step 1
					cacheValue = Math.round(cacheValue);  //Making the number clean Step 2
					cacheValue = cacheValue * preDeg; //Making the number clean Step 3
					if(cacheValue > maxCacheValue) {
						preDegUp = true;  //Increase the precision degree if we need to
					}
				}
				preDeg = preDeg / 10; //Increase the precision degree
				cacheValue = bestValue; //Take the best value to look around
				//System.out.println("DoP up (" + preDeg + ")"); //Debug value: know when Precision Degree is up
				//System.out.println("Cache Value [" + cacheValue + "]"); //Debug value: know when Cache Value is up
				currentT = System.currentTimeMillis(); //Getting the time
				unaSecunda = startStepT + (time / solSize) - currentT; //Checking if we are late
				//System.out.println("UnaSecunda value = " + unaSecunda); //Debug value: know how much time is left for this dial
				//System.out.println(); //Debug : Cleanliness
				if(preDeg < 1.0E-16) { //Overflow of Double numbers capacity
					break;
				}
			}
			sol1[op] = bestValue; //Get the best value
			op++; //Check on the next dial
			if(op == solSize) { //If we reach the last dial, then break out
				break;
			}
		}
		return sol1; //Return the array with completed dials
	}

	public static void main(String[] args) {
		System.out.println("Fitness S20 [1]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [2]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [3]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [4]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [5]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [6]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [7]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [8]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [9]: " + Assess.getTest1(getSolOne(20)));
		System.out.println("Fitness S20 [10]: " + Assess.getTest1(getSolOne(20)));

		//System.out.println("Fitness S50: " + Assess.getTest1(getSolOne(50)));
		//System.out.println("Fitness S100: " + Assess.getTest1(getSolOne(100)));
		//System.out.println("Fitness S1000: " + Assess.getTest1(getSolOne(1000)));
		//System.out.println("Fitness S100000: " + Assess.getTest1(getSolOne(100000)));
	}

}
