public class NormalizedDataset extends Dataset {
    private final Vector minInput;
    private final Vector maxInput;
    private final double minOutput;
    private final double maxOutput;

    public NormalizedDataset(Vector minInput, Vector maxInput, double minOutput, double maxOutput) {
        this.minInput = minInput;
        this.maxInput = maxInput;
        this.minOutput = minOutput;
        this.maxOutput = maxOutput;
    }

    @Override
    public Record transform(Record r) {
        int dim = minInput.getDim();
        double[] newInput = new double[dim];
        for (int i = 0; i < dim; i++) {
            double range = maxInput.getValues()[i] - minInput.getValues()[i];
            if (range == 0) range = 1;
            newInput[i] = (r.getInput().getValues()[i] - minInput.getValues()[i]) / range;
        }
        double rangeY = maxOutput - minOutput;
        if (rangeY == 0) rangeY = 1;
        double newOutput = (r.getOutput() - minOutput) / rangeY;
        return new Record(new Vector(dim, newInput), newOutput);
    }

    @Override
    public double output(double yTransformed) {
        double rangeY = maxOutput - minOutput;
        if (rangeY == 0) rangeY = 1;
        return yTransformed * rangeY + minOutput;
    }
}
