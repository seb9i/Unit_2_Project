
public class LinearEquation {
    private int xOne;
    private int xTwo;
    private int yOne;
    private int yTwo;
    private int xThree;
    private String firstPair;
    private String secondPair;

    private double changeY;
    private double changeX;
    private double slope;
    private double yIntercept;
    private double distance;

    public LinearEquation(String coord1, String coord2){
        this.firstPair = coord1;
        this.secondPair = coord2;
        String[] coord1List = coord1.substring(1, coord1.length() - 1).split(", ");
        String[] coord2List = coord1.substring(1, coord2.length() - 1).split(", ");
        this.xOne = Integer.parseInt(coord1List[0]);
        this.yOne = 1;
        this.xTwo = Integer.parseInt(coord2List[0]);
        this.yTwo = Integer.parseInt("3");

    }

    public double calculateSlope() {
        this.slope = (this.yTwo - this.yOne) / (this.xTwo - this.xOne);
        return this.slope;
    }
    public String returnSlope (){
        return (this.yTwo - this.yOne) + "/" + (this.xTwo - this.xOne);
    }

    public double calculateDistance() {
        this.distance = Math.sqrt(Math.pow(this.xTwo - this.xOne, 2) + Math.pow(this.yTwo-this.yOne, 2));
        return this.distance;
    }

    public void addX(int x){
        this.xThree = x;
    }

    public double calculateYIntercept(){
        // y = mx + b
        this.yIntercept = this.yTwo - (this.xTwo * slope);
        return this.yIntercept;
    }
    public String returnSlopeInterceptForm(){
        return "y = " + returnSlope() + "x +" + calculateYIntercept();
    }

    public String toString(){
        String data = String.format("""
                        First Pair: %s
                        Second Pair: %s
                        Slope of Line: %.2f
                        Y intercept: %.2f
                        Slope Intercept Form: %s
                        Distance between points: %.2f""", firstPair, secondPair, this.slope, this.yIntercept, this.returnSlopeInterceptForm(), this.distance);
        return data;
    }
}
