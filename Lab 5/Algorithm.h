#ifndef __ALGORITHM__
#define __ALGORITHM__

#include "Dataset.h"
#include "Model.h"

class Algorithm {
protected:
    double learningRate;
    double stoppingCriterion;

public:
    Algorithm(double lr, double sc) : learningRate(lr), stoppingCriterion(sc) {}
    Algorithm(double lr) : Algorithm(lr, 1e-6) {}

    Vector gradient(Dataset& dataset, Model& model);

    virtual Model solve(Dataset& dataset) = 0;
};

#endif
