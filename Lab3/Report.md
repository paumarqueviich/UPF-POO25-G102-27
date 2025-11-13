# Lab 3 – Linear Regression with Gradient Descent

## 1. Introduction

In this lab I implemented the design shown in Seminar 3: a complete linear regression system using gradient descent.  
I reused the classes Vector, Record, Dataset and StandardizedDataset from Lab 2 (only adding the augment() method to Vector).  
Then I created four new classes:

- Model: stores the parameter vector θ  
- Algorithm: implements gradient descent (gradient and solve methods)  
- SupervisedLearner: coordinates the dataset, the algorithm and the model  
- TestLearner: contains the main method to test everything

## 2. Design Decisions and OOP Concepts

I did iterative solution with gradient descent because it works and it allowed me to practise important OOP concepts like composition (SupervisedLearner creates and owns the Model), aggregation (Dataset and Algorithm are passed from outside and can live independently), encapsulation (the parameter vector is private and only accessible via getParams()), etc.

The implementation follows exactly the UML diagram provided.

## 3. Conclusion

Everything works correctly. When I run TestLearner, the algorithm converges in a few iterations and the learned parameters are almost identical to the true values of the toy datasets.  
The main difficulty was remembering to augment the input vector both when computing the gradient and when predicting (input.augment()). Once I fixed that, the results were good.  

The tests confirm that all classes are correctly implemented and that the composition, aggregation and dependency relationships are respected, and fulfils all the requirements of Lab 3.