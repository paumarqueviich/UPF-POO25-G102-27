#ifndef __SUPERVISEDLEARNER__
#define __SUPERVISEDLEARNER__

#include "Dataset.h"
#include "Algorithm.h"
#include <iostream>

class SupervisedLearner {
private:
    Dataset& dataset;
    Algorithm& algorithm;
    Model model;
    bool trained;

public:
    SupervisedLearner(Dataset& d, Algorithm& a)
        : dataset(d), algorithm(a), model(0), trained(false) {}

    void solve() {
        model = algorithm.solve(dataset);
        trained = true;
    }

    double predict(Vector input) {
        Record tmp(input, 0.0);
        Record tr = dataset.transform(tmp);
        double y = model.predict(tr.getInput().augment());
        return dataset.output(y);
    }

    friend std::ostream& operator<<(std::ostream& os, const SupervisedLearner& sl) {
        if (!sl.trained) os << "not trained";
        else os << sl.model;
        return os;
    }
};

#endif
