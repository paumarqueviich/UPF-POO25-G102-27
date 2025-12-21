#include "Algorithm.h"

Vector Algorithm::gradient(Dataset& dataset, Model& model) {
    int n = dataset.getRecords().size();
    Vector grad(model.getParams().getDim(), 0);

    for (Record& r : dataset.getRecords()) {
        Vector x = r.getInput().augment();
        double error = model.predict(x) - r.getOutput();
        grad = grad.add(x.mult(error));
    }
    return grad.div(n);
}
