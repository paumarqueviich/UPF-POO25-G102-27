public class TestLearner {
    public static void main(String[] args) {

        Dataset d = new Dataset() {
            @Override
            public Record transform(Record r) {
                return r;
            }
        };

        d.addRecord(new Record(new Vector(2, new double[]{1, 1}), 10));
        d.addRecord(new Record(new Vector(2, new double[]{1, 2}), 13));
        d.addRecord(new Record(new Vector(2, new double[]{2, 1}), 12));
        d.addRecord(new Record(new Vector(2, new double[]{2, 2}), 15));

        Algorithm gd = new GradientDescent(0.01, 1e-9);
        SupervisedLearner sl_gd = new SupervisedLearner(d, gd);
        sl_gd.solve();
        System.out.println(sl_gd);

        Algorithm sgd = new StochasticGradientDescent(0.01, 2000, 2, 42L);
        SupervisedLearner sl_sgd = new SupervisedLearner(d, sgd);
        sl_sgd.solve();
        System.out.println(sl_sgd);

        Vector test = new Vector(2, new double[]{3, 3});
        System.out.println(sl_gd.predict(test));
        System.out.println(sl_sgd.predict(test));

        Dataset sd = d.standardize();
        Algorithm sgdStd = new StochasticGradientDescent(0.01, 2000, 2, 123L);
        SupervisedLearner sl_sgd_std = new SupervisedLearner(sd, sgdStd);
        sl_sgd_std.solve();
        System.out.println(sl_sgd_std);
        System.out.println(sl_sgd_std.predict(test));
    }
}
