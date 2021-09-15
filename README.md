# MCO3

Learning Outcomes

This project is a venue for students to achieve the outcomes below:

LO1. Understand and differentiate various data structures through its properties and determine their applicability in problem scenarios. (CS06.01)

LO2. Recognize and represent data and/or algorithmic solutions using the most appropriate data structure for solving computing problems. (CS01.02)

LO3. Analyze and compare the efficiency of algorithms. (CS02.03)

LO4. Design and employ appropriate data structures and implement algorithmic solutions for solving computing problems, individually, or in a team, using programming language constructs revolving around data representation, acquisition, data processing and output representation. In addition, these algorithmic solutions must be effective and efficient in terms of time complexity. (CS02.03; CS03.03; CS06.01)

LO5. Manifest intellectual honesty and punctuality in the various class activities. (CS09)

This project serves as an application of binary search trees and its operations. The students will be tasked to  design and develop a Word List program that will create an alphabetical list of words with corresponding frequency count from a given text file.

Task 1 –  Design and implement your Binary Search Tree (BST) data structure
Practice modular programming. That is, compartmentalize the data structures and operations by storing the implementation codes in separate source code files.
 Decide how many BST you will need. You must use at least one BST for storing the words found in the input text file. An example strategy is to have one BST for each group of words that start with the same letter.
 At the minimum, you must have function definitions for the following BST operations:
create() – produces an empty BST
search() – determines if a search key exists in the BST
insert() – adds a new node in the BST
inorder() – performs inorder traversal of the BST
destroy() – This function should be called as a clean-up operation before the program actually terminates. If dynamic memory allocation was used, then this function will also free up the memory space. The BST will become empty after calling destroy(). 
 

Task 2 - Implement the algorithms for the BST Application
Practice good programming. Compartmentalize your solution/functions in separate source code file(s).
NOTE: You should NOT CALL any of the usual sorting algorithm for the project! The BST should handle the alphabetical ordering of words. 
Accept a named text file as input. Assume that the input text file contains a collection of words, phrases, sentences, and paragraphs in English. The table below shows sample contents of a input text file named INPUT.txt

INPUT.txt
Hello, how are you today? I am fine, thank you! How about you?

Today is the present. Tomorrow is a gift.

Design and implement an algorithm that will automatically detect and count all the English words in the input text file. The case of the words is ignored (e.g. Word = word, Hello = hello) and only words with a length of at least
3 must be included.
Output a text file named WORDS.txt. It should contain a list of the English words found in the input text file with their corresponding frequency count. The words must be in lowercase and are arranged in alphabetical order. The table below shows sample contents of the output text file named WORDS.txt based on the contents of INPUT.txt in step 2.

WORDS.txt
about	1
are	1
fine	1
gift	1
hello	1
how	2
present	1
thank	1
the	1
today	2
tomorrow	1
you	3
Practice good programming. Implement error checking. For example,  if the input text file does not exist, the program outputs “<FILENAME.TXT> not found.” error message.
 

Task 3 - Integration and Testing
Create the main module which will include the other modules.
Call the appropriate functions to achieve the tasks.
Design your test cases.
Perform exhaustive testing.
 

Task 4 - Documentation
Document your implementation following the given the template.
Give a brief description of how you implemented the data structures. Did you implement a single BST or multiple BST? Explain why.
Give a brief description of how you implemented the algorithms.
Discuss the strengths of your solution. Give examples.
Discuss the weaknesses of your solutions. What are not working? Give examples. Explain why these are not working.
