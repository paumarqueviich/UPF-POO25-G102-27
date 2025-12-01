public abstract class Algorithm {
    protected final double learningRate;
    protected final double stoppingCriterion;

    public Algorithm(double learningRate, double stoppingCriterion) {
        this.learningRate = learningRate;
        this.stoppingCriterion = stoppingCriterion;
    }

    public Algorithm(double learningRate) {
        this(learningRate, 1e-6);
    }

    public Vector gradient(Dataset dataset, Model model) {
        int n = dataset.getRecords().size();
        Vector grad = new Vector(model.getParams().getDim(), new double[model.getParams().getDim()]);
        for (Record r : dataset.getRecords()) {
            Vector x = r.getInput().augment();
            double pred = model.predict(x);
            double error = pred - r.getOutput();
            Vector term = x.mult(error);
            grad = grad.add(term);
        }
        return grad.div(n);
    }

    public abstract Model solve(Dataset dataset);
}
