rand7 - Given rand5 a function which gives {0..4} with a uniform probability, create rand7 which gives {0..6} with a uniform probability.  *This solution is nondeterministic.

rand5() * 5 + rand5() gives {0..24} a uniform probablity 

(rand5() * 5 + rand5()) % 7 gives {0..6} nonuniform probabiliy with values {0..4} being slightly more probablistic.

{0..20} % 7 gives {0..6} with a uniform probablity.

To get a random number {0..6} with uniform probablity from rand5() calculate a number 

(rand5() * 5 + rand5()) % 7 

if the sum of (rand5() * 5 + rand5()) is greater than 20, keep generating new random numbers with the above method until the sum is not greater than 20.

The need to regenerate numbers makes this solution nondeterministic.
There is a improbable chance that this method could loop for ever always generating sum's greater than 20.
If the solution does not need to be uniformly probablistic the check for sum's greater than 20 can be skipped making this solution deterministic.