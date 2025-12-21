#include "StochasticGradientDescent.h"
#include <algorithm>

Model StochasticGradientDescent::solve(Dataset& dataset) {
    Model model(dataset.getInputDim());
    auto& data = dataset.getRecords();

    for (int i = 0; i < numIterations; i++) {
        std::vector<Record> batch;
        std::sample(data.begin(), data.end(),
                    std::back_inserter(batch),
                    std::min(batchSize, (int)data.size()),
                    std::mt19937{ std::random_device{}() });

        Vector grad(model.getParams().getDim(), 0);

        for (Record& r : batch) {
            Vector x = r.getInput().augment();
            double error = model.predict(x) - r.getOutput();
            grad = grad.add(x.mult(error));
        }

        grad = grad.div(batch.size());
        if (grad.norm() < stoppingCriterion) break;
        model = model.update(grad, learningRate);
    }
    return model;
}
