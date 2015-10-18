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

/*
  Exercise 5
  How would you store a "square" function as a value? (Provide alternative to the text's example.)
 */
val square = (x: Int) => x*x

/*
  Exercise 6
  Write a function called 'conditional' that takes a value x and two functions, p and f,
  and returns a value of the same type as x. The p function is a predicate, taking the value
  x and returning a Boolean b. The f function also takes the value x and returns a new
  value of the same type.
 */

def conditional[A](x: A, p: A => Boolean, f: A => A) = {
  if (p(x)) f(x)
  else x
}

val predicate = (x: Int) => x % 2 == 0

conditional(2, predicate, square) // 4
conditional(3, predicate, square) // 3

/*
  Exercise 7
  "typesafe" as "FizzBuzz"
 */

def conditional2[A,B](x: A, p: A => Boolean, f: A => B)(g: A => B): B = {
  if (p(x)) f(x)
  else g(x)
}

def typesafe(): Unit = {
  val ts = (x: Int) => x match {
    case x if (x % 3 == 0 && x % 5 == 0) => "typesafe"
    case x if (x % 3 == 0) => "type"
    case x if (x % 5 == 0) => "safe"
    case x => x.toString()
  }

  for(i <- 1 to 100) {
    println(ts(i))
  }
}

def tsP(x: Int): Boolean = x % 3 == 0 || x % 5 == 0

def tsF(x: Int): String = x match {
  case x if (x % 3 == 0 && x % 5 == 0) => "typesafe"
  case x if (x % 3 == 0) => "type"
  case x if (x % 5 == 0) => "safe"
}

def typesafe2(): Unit = {
  val g = (x: Int) => x.toString()

  for(i <- 1 to 100) {
    println(conditional2(i, tsP, tsF)(g))
  }
}
