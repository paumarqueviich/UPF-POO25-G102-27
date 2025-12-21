#ifndef __STOCHASTICGRADIENTDESCENT__
#define __STOCHASTICGRADIENTDESCENT__

#include "Algorithm.h"
#include <random>

class StochasticGradientDescent : public Algorithm {
private:
    int batchSize;
    int numIterations;

public:
    StochasticGradientDescent(double lr, int it, int bs)
        : Algorithm(lr), batchSize(bs), numIterations(it) {}

    Model solve(Dataset& dataset) override;
};

#endif
