# PRNG
Here is a program of different PRNG algorithms researched and coded up by @3l1zzy. This is part of an Independent study at EMU for my Master’s Degree.

This program includes no GUI interface and is completely console runnable. It will ask for a seed and a maximum number any loops are allowed to run for. If -1 is entered, they will continue until the period is over for the entered seed. Please enter a seed that is at least three digits long, there is no input error checking at this time. At this point all of the generator methods are contained within the driver class, so that's really the only file you need.

The program consists of a driver method main that will call all of the pseudorandom generator methods listed below. The inputted seed is run through the middle squares' method of generation until the set cap. The output is then divided and used to seed the Lehmer method whose output feeds the Inversive Congruential method, who feeds the Linear congruential method. The output is a very long string of numbers.

It is highly recommended you use a cap inserted of letting the full pattern complete because the middle squares' algorithm is very long and does not output until the entire period has finished. The cap will ensure an upper time limit.

Generation Algorithms used:
- Middle Squares Method
- Lehmer Method
- Linear Congruential Method
- Inversive Congruential Method
