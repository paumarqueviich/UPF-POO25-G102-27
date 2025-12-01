public class SupervisedLearner {
    private final Dataset dataset;
    private final Algorithm algorithm;
    private Model model;

    public SupervisedLearner(Dataset dataset, Algorithm algorithm) {
        this.dataset = dataset;
        this.algorithm = algorithm;
    }

    public void solve() {
        this.model = algorithm.solve(dataset);
    }

    public double predict(Vector input) {
        if (model == null) throw new IllegalStateException("Call solve() first");
        Record tmp = new Record(input, 0.0);
        Record transformed = dataset.transform(tmp);
        double predTransformed = model.predict(transformed.getInput().augment());
        return dataset.output(predTransformed);
    }

    @Override
    public String toString() {
        if (model == null) return "not trained";
        return model.toString();
    }
}
