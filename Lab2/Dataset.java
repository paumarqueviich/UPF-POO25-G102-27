import java.util.ArrayList;

public class Dataset {
    private final ArrayList<Record> records = new ArrayList<>();

    public void addRecord(Record r) {
        records.add(r);
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public int getInputDim() {
        if (records.isEmpty()) return 0;
        return records.get(0).getInput().getDim();
    }

    // ---- Medias ----
    public Vector meanInput() {
        int dim = getInputDim();
        double[] sum = new double[dim];
        for (Record r : records) {
            double[] vals = r.getInput().getValues();
            for (int i = 0; i < dim; i++) sum[i] += vals[i];
        }
        int n = records.size();
        for (int i = 0; i < dim; i++) sum[i] /= n;
        return new Vector(dim, sum);
    }

    public double meanOutput() {
        double sum = 0;
        for (Record r : records) sum += r.getOutput();
        return sum / records.size();
    }

    // ---- Desviaciones estándar ----
    public Vector stdInput(Vector mean) {
        int dim = getInputDim();
        double[] sumsq = new double[dim];
        for (Record r : records) {
            double[] vals = r.getInput().getValues();
            for (int i = 0; i < dim; i++) {
                double diff = vals[i] - mean.getValues()[i];
                sumsq[i] += diff * diff;
            }
        }
        int n = records.size();
        for (int i = 0; i < dim; i++) sumsq[i] = Math.sqrt(sumsq[i] / n);
        return new Vector(dim, sumsq);
    }

    public double stdOutput(double mean) {
        double sumsq = 0;
        for (Record r : records) {
            double diff = r.getOutput() - mean;
            sumsq += diff * diff;
        }
        return Math.sqrt(sumsq / records.size());
    }

    // ---- Crear datasets derivados ----
    public StandardizedDataset standardize() {
        Vector meanX = meanInput();
        Vector stdX = stdInput(meanX);
        double meanY = meanOutput();
        double stdY = stdOutput(meanY);

        StandardizedDataset sd = new StandardizedDataset(meanX, stdX, meanY, stdY);
        for (Record r : records) sd.addRecord(sd.transform(r));
        return sd;
    }

    public NormalizedDataset normalize() {
        int dim = getInputDim();
        double[] min = new double[dim];
        double[] max = new double[dim];
        for (int i = 0; i < dim; i++) {
            min[i] = Double.POSITIVE_INFINITY;
            max[i] = Double.NEGATIVE_INFINITY;
        }
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;

        for (Record r : records) {
            double[] vals = r.getInput().getValues();
            for (int i = 0; i < dim; i++) {
                if (vals[i] < min[i]) min[i] = vals[i];
                if (vals[i] > max[i]) max[i] = vals[i];
            }
            double y = r.getOutput();
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        NormalizedDataset nd = new NormalizedDataset(new Vector(dim, min), new Vector(dim, max), minY, maxY);
        for (Record r : records) nd.addRecord(nd.transform(r));
        return nd;
    }
}
