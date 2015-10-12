/*
  Exercise 1: Write a function that computes the area of a circle given its radius.
 */

def area(radius: Double): Double = {
  radius * radius * 3.141
}

/*
  Exercise 2: Write an alternate form of area that takes the radius as a String.
 */

def area2(radius: String): Double = {
  if (radius == "") {
    0.0
  }
  else {
    val r = radius.toDouble
    r * r * 3.141
  }
}