public class Vector {

    private final double[] values;
    private final int dim;

    public Vector(int dim, double[] values) {
        this.dim = dim;
        this.values = values;
    }

    public int getDim() {
        return dim;
    }

    public Vector add(Vector v) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] + v.values[i];
        return new Vector(dim, r);
    }

    public Vector subtract(Vector v) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] - v.values[i];
        return new Vector(dim, r);
    }

    public Vector multiply(Vector v) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] * v.values[i];
        return new Vector(dim, r);
    }

    public Vector divide(Vector v) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] / v.values[i];
        return new Vector(dim, r);
    }

    public Vector mult(double n) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] * n;
        return new Vector(dim, r);
    }

    public Vector div(double n) {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = values[i] / n;
        return new Vector(dim, r);
    }

    public Vector sqrt() {
        double[] r = new double[dim];
        for (int i = 0; i < dim; i++) r[i] = Math.sqrt(values[i]);
        return new Vector(dim, r);
    }

    public double dot(Vector v) {
        double sum = 0;
        for (int i = 0; i < dim; i++) sum += values[i] * v.values[i];
        return sum;
    }

    public double norm() {
        double sum = 0;
        for (int i = 0; i < dim; i++) sum += values[i] * values[i];
        return Math.sqrt(sum);
    }

    public double[] getValues() { 
        return values;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < dim; i++) text += values[i] + " ";
        text += "]";
        return text;
    }    
    public Vector augment() {
        double[] augmented = new double[dim + 1];
        System.arraycopy(values, 0, augmented, 0, dim);
        augmented[dim] = 1.0;
        return new Vector(dim + 1, augmented);
    }
}
