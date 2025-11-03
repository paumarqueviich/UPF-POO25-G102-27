# Lab 2 Report – Dataset Standardization and Normalization
## 1. Introduction

In this lab we had to implement a small Java program to manage datasets made of input–output pairs.  
Each record has a vector of inputs (Vector) and one numeric output (double).  
The main goal was to build classes that can:

- Store multiple records (Dataset)
- Calculate the mean and standard deviation of the data
- Create new datasets where the values are:
  - **Standardized** (mean 0, std 1)
  - **Normalized** (range [0, 1])

The classes used were:

- `Vector`: represents a vector of numbers and supports operations like add, subtract, etc.  
- `Record`: stores one input vector and one output value.  
- `Dataset`: stores a list of records and calculates statistics.  
- `StandardizedDataset`: extends Dataset and standardizes the data.  
- `NormalizedDataset`: extends Dataset and normalizes the data.


## 2. Design and Solution

At first I thought about using simple arrays (double[][] for inputs), but that would make the code harder to organize and read.  
Using objects and classes is better because each class has a clear job.

In the final version I used:
- Record to store the data points.
- Dataset to calculate mean and standard deviation.
- StandardizedDataset and NormalizedDataset to transform the data.

The program applies object-oriented programming ideas like:
- **Encapsulation**: data inside each class is private.  
- **Inheritance**: the new datasets extend Dataset.  
- **Composition**: each dataset contains several records, and each record contains a vector.

This design is easier to maintain and reuse in future labs.

## 3. Conclusion

The code worked correctly after fixing a few issues.  
I had to add a small method getValues() to the Vector class so that the dataset classes could access its elements.

After testing with simple examples, the standardized data had values around zero, and the normalized data was correctly between 0 and 1.

The hardest part was understanding the difference between normalization and standardization and making sure there were no division-by-zero errors.  
Overall, the lab went well and helped me practice inheritance and working with multiple classes in Java.


