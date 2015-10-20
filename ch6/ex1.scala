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