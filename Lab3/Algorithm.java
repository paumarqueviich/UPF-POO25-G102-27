public class Algorithm {
    private final double learningRate;
    private final double stoppingCriterion;

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

    public Model solve(Dataset dataset) {
        Model model = new Model(dataset.getInputDim());

        while (true) {
            Vector grad = gradient(dataset, model);
            if (grad.norm() < stoppingCriterion) {
                break;
            }
            model = model.update(grad, learningRate);
        }
        return model;
    }
}