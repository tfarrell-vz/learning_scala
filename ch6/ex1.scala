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
