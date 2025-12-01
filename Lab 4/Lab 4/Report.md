# Lab 4 – Stochastic Gradient Descent  
## Report

## 1. Introduction

In this lab, I expanded the structure of the project I already had from previous labs. I reused the basic system classes (vectors, records, and the linear model), but I had to modify the dataset part to allow applying transformations and also reversing them when making predictions.

Additionally, I added two training algorithms: the "normal" Gradient Descent and the new Stochastic Gradient Descent (SGD) version, which works with mini-batches. The goal was to train a linear model using both methods and verify that they work correctly.

---

## 2. Design and Decisions Made

The part I had to reorganize the most was dataset management. To standardize data and then reverse the transformation when predicting, I needed the dataset to handle transforming inputs and outputs itself. Therefore, I converted the dataset class into an abstract one, and the transformed versions (standardized or normalized) implement their own transformations.

Regarding the algorithms, I preferred to completely separate classic gradient descent from stochastic gradient descent by creating a new class for SGD instead of mixing everything in a single class. This way, the code is cleaner and it is easier to experiment with each method.

I implemented SGD by selecting random mini-batches without replacement in each iteration because it was simple and worked well for the size of the dataset in this exercise.

---

## 3. Conclusion

The results were correct: both methods ended up approximating the model well, and predictions work even when the dataset is transformed because the inverse transformation is applied automatically. The only thing that required a bit more testing was adjusting the learning rate and the number of iterations so that SGD would not take too long or get stuck oscillating.

Overall, the final design is quite clear and easy to extend for future exercises.
