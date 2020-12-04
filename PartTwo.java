//A packing algorithm, sorting items by the ratio weight/utility
//Runtime : <1s
//Fitness : ~209, pretty good but not perfect

import java.lang.Math;
import java.util.*;

class PartTwo {

    public static boolean[] getSol2() {
        int solSize = 100;
        double weightLimit = 500;
        boolean[] sol2 = new boolean[solSize];
        int count = 0;
        ArrayList<PartTwoItem> organisedItems = new ArrayList();
        for (Boolean bool: sol2) {
            boolean[] tmpSol = new boolean[solSize];
            tmpSol[count] = true;
            double[] tmp = Assess.getTest2(tmpSol);
            PartTwoItem tmpItem = new PartTwoItem(count, tmp[0], tmp[1]);
            organisedItems.add(tmpItem);
            //System.out.println(organisedItems.get(count).toString());
            count++;
        }
        Collections.sort(organisedItems);
        double totalWeight = 0;
        for (PartTwoItem item : organisedItems) {
            //System.out.println(item.toString());
            double tempWeight = totalWeight + item.getWeight();
            if(tempWeight <= weightLimit) {
                sol2[item.getPosition()] = true;
                totalWeight = tempWeight;
                //System.out.println(item.toString());
            }
        }
        return sol2;
    }

    public static void main(String[] args) {
        System.out.println("Fitness [1]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [2]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [3]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [4]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [5]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [6]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [7]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [8]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [9]: " + Assess.getTest2(getSol2()));
        System.out.println("Fitness [10]: " + Assess.getTest2(getSol2()));

        //System.out.println("Fitness S50: " + Assess.getTest1(getSolOne(50)));
        //System.out.println("Fitness S100: " + Assess.getTest1(getSolOne(100)));
        //System.out.println("Fitness S1000: " + Assess.getTest1(getSolOne(1000)));
        //System.out.println("Fitness S100000: " + Assess.getTest1(getSolOne(100000)));
    }

}
