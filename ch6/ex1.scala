/* Exercise 1
  Create a list of the first 20 odd Long numbers.
   - for-loop
   - filter
   - map
   What's most efficient and expressive?
 */

def firstTwentyOddLong(): List[Long] = {
  var a: List[Int] = List()
  for (i <- 1 to 40) {
    a = i :: a
  }

  a.filter((x: Int)=>x % 2 == 1).reverse.map((x: Int)=> x.toLong)
}

println(firstTwentyOddLong())

def firstTwentyOddLongImmutable(): List[Long] = {
  def loop(i: Int, term: Int, acc: List[Long]): List[Long] = {
    if (i > term) acc
    else if (i % 2 == 1) loop(i+1, term, i.toLong :: acc)
    else loop(i + 1, term, acc)
  }
  loop(1, 40, List()).reverse
}

println(firstTwentyOddLongImmutable())

firstTwentyOddLong() == firstTwentyOddLongImmutable() // true ;)


/*
 Write a function that returns a list of a numbers factors.
 */
def factors(n: Int): List[Int] = {
  def loop(i: Int, len: Int, acc: List[Int]): List[Int] = {
    if (i >= len) acc.reverse
    else {
      if (len % i == 0) loop(i+1, n, i :: acc)
      else loop(i+1, n, acc)
    }
  }
  if (n >= 2) loop(2, n, List())
  else List()
}