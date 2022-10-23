package DP;

// Target Sum [Count the number of subset with a given difference]

// arr[] = {1, 1, 2, 3}
// sum = 1
// o/p : 3

// here we have to assign sign(+/-) for all the eles in order to sum of all eles becomes given sum(target)

//  +1 -1  -2 +3 = 1
//  -1 +1  -2 +3 = 1
//  +1 +1  +2 -3 = 1
// o/p : 3

// this problem same as prev problem
//  {1,3} {1,2}  => 4 - 3 = 1
//  {1,1,2} , {3} => 4 - 3 = 1
//  {1,3} {1,2} => 4 - 3 = 1
// o/p = 3

// sum(s1) - sum(s2) = target   ---- 1  [our goal (count)]
// sum(s1) + sum(s2) = totalSum ---- 2  [we know]
//  2sum(s1) = target + totalSum        [solve 2 equations]