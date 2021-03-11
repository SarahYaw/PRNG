# PRNG
Here is a program of different PRNG algorithms researched and coded up by @3l1zzy .
This is part of an Independant study at EMU for my Masters Degree.
This program includes no GUI interface and is compleatly console runnable. It will as for a seed and a maximum number any loops are allowed to run for. If -1 is entered, they will continue until the period is over for the entered seed. Please enter a seed that is at lease three digits long, there is no input error checking at this time.
The program consists of a driver method main that will call all of the psuedorandom generator methods listed below. At this point all of the generator methods are contained within the driver class, so that's really the only file you need.
Generation Algorithms used:
- Middle Squares Method
- Lehmer Method
