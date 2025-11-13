public class TestLearner {
    public static void main(String[] args) {
        Dataset d = new Dataset();

        d.addRecord(new Record(new Vector(2, new double[]{1, 1}), 10));
        d.addRecord(new Record(new Vector(2, new double[]{1, 2}), 13));
        d.addRecord(new Record(new Vector(2, new double[]{2, 1}), 12));
        d.addRecord(new Record(new Vector(2, new double[]{2, 2}), 15));

        Algorithm a = new Algorithm(0.01);
        SupervisedLearner sl = new SupervisedLearner(d, a);

        System.out.println("training...");
        sl.solve();

        System.out.println(sl);

        Vector test1 = new Vector(2, new double[]{3, 3});
        System.out.println("predict [3,3] = " + sl.predict(test1));
    }
}