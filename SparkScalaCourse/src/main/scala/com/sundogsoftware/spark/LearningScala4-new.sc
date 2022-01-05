// Data structures

// Tuples
// Immutable lists

val captainStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
println(captainStuff)

// Refer to the individual fields with a ONE-BASED index
println(captainStuff._1)
println(captainStuff._2)
println(captainStuff._3)

val picardsShip = "Picard" -> "Enterprise-D"
println(picardsShip._2)

val aBunchOfStuff = ("Kirk", 1964, true)

// Lists
// Like a tuple, but more functionality
// Must be of same type

val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")

println(shipList(1))
// zero-based

println(shipList.head)
print(shipList.tail)

for (ship <- shipList) {
  println(ship)
}

val backwardShips = shipList.map( (ship: String) => {ship.reverse})
for (ship <- backwardShips) {println(ship)}

// reduce() to combine together all the items in a collection using some function
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x: Int, y: Int) => x+ y)
println(sum)

// filter() removes stuff
val iHateFives = numberList.filter( (x: Int) => x != 5)

val iHateThrees = numberList.filter(_ != 3)

// Concatenate lists
val moreNumbers = List(6,7,8)
val lotsOfNumbers = numberList ++ moreNumbers

val reversed = numberList.reverse
val sorted = reversed.sorted
val lotsOfDuplicates = numberList ++ numberList
val distinctValues = lotsOfDuplicates.distinct
val maxValue = numberList.max
val total = numberList.sum
val hasThree = iHateThrees.contains(3)

// MAPS
val shipMap = Map("Kirk" -> "Enterpise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")
println(shipMap("Janeway"))
println(shipMap.contains("Archer"))
val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
println(archersShip)

