public class Model {
    private final Vector params;

    public Model(int inputDim) {
        this.params = new Vector(inputDim + 1, new double[inputDim + 1]);
    }

    private Model(Vector params) {
        this.params = params;
    }

    public double predict(Vector x) {
        return params.dot(x);
    }

    public Model update(Vector gradient, double learningRate) {
        Vector delta = gradient.mult(learningRate);
        Vector newParams = params.subtract(delta);
        return new Model(newParams);
    }

    public Vector getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "Model θ = " + params;
    }
}