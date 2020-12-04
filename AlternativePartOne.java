//An alternative part one, which uses a slower GA (Runtime: 3S; Fitness between E-6 and E-7)

import java.lang.Math;
import java.util.*;

class AlternativePartOne {

	public static double[] getSolOne(int solSize) {
		long startT=System.currentTimeMillis();
		long currentT = 0;
		double[] sol1= new double[solSize];
		for(int j=0; j<solSize;j++){sol1[j] = 0;}
		int op = 0;
		long time = 3000; //20000 = 20 seconds
		while((startT + time) > currentT) {
			long startStepT=System.currentTimeMillis();
			double bestFitness = 9999999;
			double bestValue = 9999999;
			long unaSecunda = startStepT + (time / solSize) - currentT;
			while(unaSecunda > System.currentTimeMillis()) {
				double value = Math.random()*Math.round(5.12*(Math.random() - Math.random()));
				sol1[op] = value;
				if(Assess.getTest1(sol1) < bestFitness) {
					bestFitness = Assess.getTest1(sol1);
					bestValue = value;
					//System.out.println("New fitness:" + bestFitness);
					//System.out.println("New value at " + op + ":" + bestValue);
					//System.out.println();
				}
			}
			sol1[op] = bestValue;
			op++;
			if(op == solSize) {
				break;
			}
		}
		//for (Double doub: sol1) {
			//System.out.println(doub);
		//}
		return sol1;
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
