import java.text.DecimalFormat;
// Decimal Format
public class LinearEquation {
    private double xOne;
    private double xTwo;
    private double yOne;
    private double yTwo;
    private double xThree;
    private String firstPair;
    private String secondPair;

    private double changeY;
    private double changeX;
    private double slope;
    private double yIntercept;
    private double distance;

    DecimalFormat d = new DecimalFormat("#.##");

    public LinearEquation(String coord1, String coord2){
        this.firstPair = coord1;
        this.secondPair = coord2;
        String[] coord1List = coord1.substring(1, coord1.length() - 1).split(", ");
        String[] coord2List = coord2.substring(1, coord2.length() - 1).split(", ");
        this.xOne = Double.parseDouble(coord1List[0]);
        this.yOne = Double.parseDouble(coord1List[1]);
        this.xTwo = Double.parseDouble(coord2List[0]);
        this.yTwo = Double.parseDouble(coord2List[1]);
        calculateSlope();
        calculateDistance();
        calculateYInterceptString();

    }

    public double calculateSlope() {
        this.slope = (this.yTwo - this.yOne) / (this.xTwo - this.xOne);
        return this.slope;
    }

    public String returnSlope () {

        if (this.slope % 2 == 0 && this.slope > 1){

            return String.valueOf(this.slope);
        }
        if (this.slope == 1){
            return "";
        }

        if ((this.xTwo - this.xOne) < 0){
            return "-" + d.format(this.yTwo - this.yOne) + "/" +  d.format(Math.abs((this.xTwo - this.xOne)));
        }
        return d.format(this.yTwo - this.yOne) + "/" +  d.format(Math.abs((this.xTwo - this.xOne)));


    }

    public double calculateDistance() {
        this.distance = Math.sqrt(Math.pow(this.xTwo - this.xOne, 2) + Math.pow(this.yTwo-this.yOne, 2));
        return this.distance;
    }

    public void addX(int x){
        this.xThree = x;
    }

    public String solveCoordinate(){
        double solvedX = this.xThree;
        double solvedY = (this.slope * solvedX) + this.yIntercept;
        return String.format("(%.1f, %.1f)", solvedX, solvedY);
    }
    public void calculateYInterceptString(){
        // y = mx + b
        this.yIntercept = this.yTwo - (this.xTwo * slope);
    }
    public String returnYInterceptString(){

        return d.format(this.yIntercept);
    }
    public String returnSlopeInterceptForm(){
        if (this.yIntercept == 0) {
            return "y = " + returnSlope() + "x";
        }
        else if (this.yIntercept < 0){
            return "y = " + returnSlope() + "x " + returnYInterceptString();
        }
        return "y = " + returnSlope() + "x + " + returnYInterceptString();
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
