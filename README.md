# TextAlign

This is my solution to the technical task where I was supposed to create a program for aligninging text based on a formatting type, an output width and an input string!

## Comments on behavior
I could not figure out what the formatting type of "hard" was supposed to actually do, so I've left that one out.

The "justify" formatting also acts funky when handling even numbers of words on a line, when said line has more than two words. Probably due to my rather messy and probably also very suboptimal implementation of one of the methods that is supposed to handle the justify functionality.

## Notes on testing
Not everything has been test associated with it, but about 80% of the code base has test coverage - and all the relevant formatting logic should be covered in tests.

Testsuite can be found in the class AllTests.

The naming convention that I've used for my test has been {nameOfMethod}Test_{input/testType}_{expectedOutput}.
