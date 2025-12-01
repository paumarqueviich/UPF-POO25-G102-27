public class Record {

    private final Vector input;
    private final double output;

    public Record(Vector input, double output) {
        this.input = input;
        this.output = output;
    }

    public Vector getInput() {
        return input;
    }

    public double getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "Record(input=" + input + ", output=" + output + ")";
    }
}