import java.text.DecimalFormat;
// Decimal Format
public class LinearEquation {
    final private double xOne;
    final private double xTwo;
    final private double yOne;
    final private double yTwo;
    private double xThree;
    final private String firstPair;
    final private String secondPair;

    private double changeY;
    private double changeX;
    private double slope;
    private double yIntercept;
    private double distance;

    DecimalFormat d = new DecimalFormat("#.##");

    // Constructor for class
    public LinearEquation(String coord1, String coord2){
        this.firstPair = coord1;
        this.secondPair = coord2;

        // Logic for separating coordinate values from strings using split
        String[] coord1List = coord1.substring(1, coord1.length() - 1).split(", ");
        String[] coord2List = coord2.substring(1, coord2.length() - 1).split(", ");


        this.xOne = Double.parseDouble(coord1List[0]);
        this.yOne = Double.parseDouble(coord1List[1]);
        this.xTwo = Double.parseDouble(coord2List[0]);
        this.yTwo = Double.parseDouble(coord2List[1]);

        // Calculating values
        calculateSlope();
        calculateDistance();
        calculateYIntercept();

    }

    public void calculateSlope() {
        this.slope = (this.yTwo - this.yOne) / (this.xTwo - this.xOne);
    }

    public String returnSlope () {
        // Whole number case
        if (this.slope % 2 == 0 && this.slope > 1){
            return String.valueOf(this.slope);
        }
        // Equal to one case
        if (this.slope == 1){
            return "";
        }
        // Eliminating double negative signs
        if (this.slope < 0){
            return "-" + d.format(this.yTwo - this.yOne) + "/" +  d.format(Math.abs((this.xTwo - this.xOne)));
        }
        else {
            return d.format(Math.abs(this.yTwo - this.yOne)) + "/" +  d.format(Math.abs((this.xTwo - this.xOne)));
        }
    }

    public void calculateDistance() {
        this.distance = Math.sqrt(Math.pow(this.xTwo - this.xOne, 2) + Math.pow(this.yTwo-this.yOne, 2));
    }

    // Add third coordinate
    public void addX(int x){
        this.xThree = x;
    }

    // Solve with extra coordinate, returns coordinate up to 2 decimal values
    public String solveCoordinate(){
        double solvedX = this.xThree;
        double solvedY = (this.slope * solvedX) + this.yIntercept;
        return String.format("(%.2f, %.2f)", solvedX, solvedY);
    }
    // Calculate the Y-intercept
    public void calculateYIntercept(){
        // y = mx + b
        this.yIntercept = this.yTwo - (this.xTwo * slope);
    }
    // Return Y-intercept rounded to two decimal places
    public String returnYInterceptString(){
        return d.format(this.yIntercept);
    }

    // Return slope intercept form
    public String returnSlopeInterceptForm(){
        // When Y-intercept is equal to 0, don't print it
        if (this.yIntercept == 0) {
            return "y = " + returnSlope() + "x";
        }
        // Handling double negatives if Y-intercept is negative
        else if (this.yIntercept < 0){
            return "y = " + returnSlope() + "x " + returnYInterceptString();
        }
        return "y = " + returnSlope() + "x + " + returnYInterceptString();
    }

    // Overriding the print method for the class so it doesn't return a memory address
    public String toString(){
        return String.format("""
                        First Pair: %s
                        Second Pair: %s
                        Slope of Line: %.2f
                        Y intercept: %.2f
                        Slope Intercept Form: %s
                        Distance between points: %.2f""", firstPair, secondPair, this.slope, this.yIntercept, this.returnSlopeInterceptForm(), this.distance);
    }
}
