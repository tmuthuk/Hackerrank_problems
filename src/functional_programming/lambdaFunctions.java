package functional_programming;

/**
 * Practice for functional programming
 */
public class lambdaFunctions {
    public static void main(String args[]) {
        double value = 4.7;
        LambdaType1 circleArea = val -> {
          System.out.println(Math.PI*val*val);
          System.out.println(val);
        };

        LambdaType1 squareArea = val -> System.out.println(val);

        circleArea.xyz_doesntmatter(value);
        squareArea.xyz_doesntmatter(value);

    }
}

interface LambdaType1 {
    void xyz_doesntmatter(double val);
}
