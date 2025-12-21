#include <iostream>
#include "GradientDescent.h"
#include "StochasticGradientDescent.h"
#include "SupervisedLearner.h"

int main() {
    Dataset d;

    d.addRecord(Record(Vector(2, {1,1}), 10));
    d.addRecord(Record(Vector(2, {1,2}), 13));
    d.addRecord(Record(Vector(2, {2,1}), 12));
    d.addRecord(Record(Vector(2, {2,2}), 15));

    GradientDescent gd(0.01, 1e-9);
    SupervisedLearner sl1(d, gd);
    sl1.solve();
    std::cout << sl1 << std::endl;

    StochasticGradientDescent sgd(0.01, 2000, 2);
    SupervisedLearner sl2(d, sgd);
    sl2.solve();
    std::cout << sl2 << std::endl;

    Vector test(2, {3,3});
    std::cout << sl1.predict(test) << std::endl;
    std::cout << sl2.predict(test) << std::endl;

    return 0;
}
