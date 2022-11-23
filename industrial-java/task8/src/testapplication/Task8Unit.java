package testapplication;

public class Task8Unit {

    public static double myExp(double a, double b, double c, double d, double x) throws Exception {
        double y;
        if (x <= 5) {
            y = (Math.pow(a, 2) * c + Math.pow(b, 2) - d) / x ;
        } else {
            y = Math.pow(x, 2) + 5;
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            return y;
        } else {
            throw new Exception("Нельзя делить на 0.");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(myExp(7, 4, 5, 2, 6));
    }

}
