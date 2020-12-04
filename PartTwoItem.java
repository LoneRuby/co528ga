//A class used by Part 2, allowing to sort object by the ration Weight/Utility

public class PartTwoItem implements Comparable{

    private int position;
    private double weight;
    private double utility;
    private double wou; //Weight Over Utility

    public PartTwoItem(int position, double weight, double utility) {
        this.position = position;
        this.weight = weight;
        this.utility = utility;
        this.wou = weight / utility;
    }

    public double getWou() {
        return wou;
    }

    public int getPosition() {
        return position;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return ("{Position: " + position + "; Weight: " + weight + "; Utility:" + utility + "; WoU:" + wou +"}");
    }

    @Override
    public int compareTo(Object o) {
        double oWoU = ((PartTwoItem) o).getWou(); //As it is made for a specific usage, I can do this abstraction that every object submitted will be a PartTwoItem
        if(Double.compare(this.getWou(), oWoU) == 0.000000000) {
            return Double.compare(this.getWeight(), weight);
        } else {
            return Double.compare(this.getWou(), oWoU);
        }
    }
}
