public class GradientDescent extends Algorithm {

    public GradientDescent(double learningRate, double stoppingCriterion) {
        super(learningRate, stoppingCriterion);
    }

    public GradientDescent(double learningRate) {
        super(learningRate);
    }

    @Override
    public Model solve(Dataset dataset) {
        Model model = new Model(dataset.getInputDim());
        while (true) {
            Vector grad = gradient(dataset, model);
            if (grad.norm() < stoppingCriterion) break;
            model = model.update(grad, learningRate);
        }
        return model;
    }
}
