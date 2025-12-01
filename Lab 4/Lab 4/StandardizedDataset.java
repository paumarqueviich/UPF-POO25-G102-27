public class StandardizedDataset extends Dataset {
    private final Vector meanInput;
    private final Vector stdInput;
    private final double meanOutput;
    private final double stdOutput;

    public StandardizedDataset(Vector meanInput, Vector stdInput, double meanOutput, double stdOutput) {
        this.meanInput = meanInput;
        this.stdInput = stdInput;
        this.meanOutput = meanOutput;
        this.stdOutput = stdOutput;
    }

    @Override
    public Record transform(Record r) {
        int dim = meanInput.getDim();
        double[] newInput = new double[dim];
        for (int i = 0; i < dim; i++) {
            double s = stdInput.getValues()[i];
            if (s == 0) s = 1;
            newInput[i] = (r.getInput().getValues()[i] - meanInput.getValues()[i]) / s;
        }
        double newOutput = (r.getOutput() - meanOutput) / (stdOutput == 0 ? 1 : stdOutput);
        return new Record(new Vector(dim, newInput), newOutput);
    }

    @Override
    public double output(double yTransformed) {
        return yTransformed * (stdOutput == 0 ? 1 : stdOutput) + meanOutput;
    }
}
