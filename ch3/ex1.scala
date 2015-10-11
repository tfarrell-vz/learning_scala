/*
  Given a string name, write a match expression that will return the same string if nonempty,
  or else the string "n/a" if it is empty.
 */

def stringOrNot(name: String): String = name match {
  case "" => "n/a"
  case name => name
}