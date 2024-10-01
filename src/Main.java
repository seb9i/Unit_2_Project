public class Main {
    public static void main(String[] args) {
        String x = ("(112, 52)");
        System.out.println(x.substring(1, x.length() - 1).split(",")[1]);
    }
}