package LeetCodeUtils;

public class Vector {

    /**
     *  assume that the clockwise is the positive degree
     * @param direction
     * @param degree represents the number of degree in 360 scale
     */
    public static void rotateVector(double[] direction, double degree) {
        degree = -degree;
        double x = direction[0], y = direction[1];
        direction[0] = x * Math.cos(degree / 180 * Math.PI) - y * Math.sin(degree / 180 * Math.PI);
        direction[1] = x * Math.sin(degree / 180 * Math.PI) + y * Math.cos(degree / 180 * Math.PI);
    }

}
