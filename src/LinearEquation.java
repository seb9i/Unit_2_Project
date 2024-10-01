
public class LinearEquation {
    private int xOne;
    private int xTwo;
    private int yOne;
    private int yTwo;
    private int yThree;

    private double changeY;
    private double changeX;
    private String slope;
    private double yIntercept;
    private double distance;

    public LinearEquation(String coord1, String coord2){
        String[] coord1List = coord1.substring(1, coord1.length() - 1).split(",");
        String[] coord2List = coord1.substring(1, coord2.length() - 1).split(",");
        this.xOne = Integer.parseInt(coord1List[0]);
        this.yOne = Integer.parseInt(coord1List[0]);
        this.xTwo = Integer.parseInt(coord1List[0]);
        this.xTwo = Integer.parseInt(coord1List[0]);

    }
}
