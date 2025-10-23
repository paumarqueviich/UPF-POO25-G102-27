public class TestRecord {

    public static void main(String[] args) {

        double[] a = {1, 4, 9};
        double[] b = {2, 3, 4};

        Vector v1 = new Vector(3, a);
        Vector v2 = new Vector(3, b);

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println();

        System.out.println("v1 + v2 = " + v1.add(v2));
        System.out.println("v1 - v2 = " + v1.subtract(v2));
        System.out.println("v1 * v2 = " + v1.multiply(v2));
        System.out.println("v1 / v2 = " + v1.divide(v2));
        System.out.println("v1 * 2 = " + v1.mult(2));
        System.out.println("v2 / 2 = " + v2.div(2));
        System.out.println("sqrt(v1) = " + v1.sqrt());
        System.out.println("v1 · v2 = " + v1.dot(v2));
        System.out.println("||v1|| = " + v1.norm());
        System.out.println();

        Record r = new Record(v1, 7.5);
        System.out.println("Record: " + r);
    }
}
