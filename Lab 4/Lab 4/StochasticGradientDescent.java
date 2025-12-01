import java.util.Random;

public class StochasticGradientDescent extends Algorithm {
    private final int batchSize;
    private final int numIterations;
    private final Random rnd;

    public StochasticGradientDescent(double learningRate, int numIterations, int batchSize, long seed) {
        super(learningRate);
        this.batchSize = batchSize;
        this.numIterations = numIterations;
        this.rnd = new Random(seed);
    }

    public StochasticGradientDescent(double learningRate, int numIterations, int batchSize) {
        this(learningRate, numIterations, batchSize, System.currentTimeMillis());
    }

    private Vector stochasticGradient(Dataset dataset, Model model) {
        int n = dataset.getRecords().size();
        int k = Math.min(batchSize, n);
        int[] indices = rnd.ints(0, n).distinct().limit(k).toArray();

        Vector grad = new Vector(model.getParams().getDim(), new double[model.getParams().getDim()]);
        for (int i : indices) {
            Record r = dataset.getRecords().get(i);
            Vector x = r.getInput().augment();
            double pred = model.predict(x);
            double error = pred - r.getOutput();
            Vector term = x.mult(error);
            grad = grad.add(term);
        }
        return grad.div(k);
    }

    @Override
    public Model solve(Dataset dataset) {
        Model model = new Model(dataset.getInputDim());
        for (int it = 0; it < numIterations; it++) {
            Vector grad = stochasticGradient(dataset, model);
            if (grad.norm() < stoppingCriterion) break;
            model = model.update(grad, learningRate);
        }
        return model;
    }
}
