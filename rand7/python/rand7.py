#!/usr/bin/python

import random

def rand5():
	return random.randrange(0,5)

def rand7():
	sum = 21
	while sum > 20:
		sum  = rand5() * 5 + rand5()

	return sum % 7


results = [0] * 7
for iteration in range (0, 100000):
	result = rand7()
	results[result] += 1

for i in range (0, 7):
	print "%d came up %d times" % (i, results[i])
	

