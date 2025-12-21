#include "GradientDescent.h"

Model GradientDescent::solve(Dataset& dataset) {
    Model model(dataset.getInputDim());

    while (true) {
        Vector grad = gradient(dataset, model);
        if (grad.norm() < stoppingCriterion) break;
        model = model.update(grad, learningRate);
    }
    return model;
}
