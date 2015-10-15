/*
  Exercise 1; Write a function literal that takes two integers and returns the higher number.
  Then write a higher-order function that takes a 3-sized tuple of integers plus this function literal
  to return the maximum value in the tuple.
 */

val funcLiteralMax = (x: Int, y: Int) => if (x > y) x else y

def appliedToThree(three: (Int, Int, Int), f: (Int, Int)=>Int): Int = {
  // Assumes that f is associative.
  f(f(three._1, three._2), three._3)
}

/* Exercise 3
  Write a higher-order function that takes an integer and returns a function. The returned
  function should take a single integer argument (say, "y") and return the product of y
  and the integer passed to the function.
 */

def takeInt(n: Int): (Int=>Int) = {
  (y: Int) => y * n
}