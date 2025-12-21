# Lab 5 Report

## 1. Introduction
[cite_start]In this lab, the goal was to implement Linear Regression in C++[cite: 5]. [cite_start]The task was to create four classes: `Algorithm`, `GradientDescent`, `StochasticGradientDescent`, and `SupervisedLearner`[cite: 7]. [cite_start]The main idea was to translate the logic we already knew from Java but applying C++ inheritance syntax[cite: 109].

## 2. Solution and Design
I followed the lab guidelines to adapt the code to C++:

* [cite_start]**Abstraction:** Since C++ does not have the `abstract` keyword [cite: 103][cite_start], I defined the `solve` method as a "pure virtual function" (ending with `= 0`) in the `Algorithm` class to force subclasses to implement it[cite: 104].
* [cite_start]**Memory Management:** Instead of using the `new` keyword (which creates pointers and requires manual deletion), I initialized objects directly as recommended in the instructions[cite: 83, 84]. This made the code cleaner because I didn't have to worry about memory leaks.

## 3. Conclusion and Difficulties
The implementation logic was similar to previous labs, but I faced some technical issues. I had trouble with the compiler not finding the files, getting errors like `cannot open source file "Dataset.h"` and even `iostream`. [cite_start]This happened because, unlike Java, C++ does not automatically include files from the same directory[cite: 89]. Once I fixed the include paths in Visual Studio Code and ensured every file had the correct `#include`, the project compiled and the tests passed successfully.