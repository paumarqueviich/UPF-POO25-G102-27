#ifndef __GRADIENTDESCENT__
#define __GRADIENTDESCENT__

#include "Algorithm.h"

class GradientDescent : public Algorithm {
public:
    GradientDescent(double lr, double sc) : Algorithm(lr, sc) {}
    GradientDescent(double lr) : Algorithm(lr) {}

    Model solve(Dataset& dataset) override;
};

#endif
