object Solution {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val sortedPeople = people.sortWith {
      case (a, b) =>
        if (a(0) == b(0)) a(1) < b(1) else a(0) > b(0)
    }

    val queue = collection.mutable.ListBuffer.empty[Array[Int]]

    for (p <- sortedPeople) {
      queue.insert(p(1), p)
    }

    queue.toArray
  }
}

// Example usage:
val people = Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))

val queue = Solution.reconstructQueue(people)

for (person <- queue) {
  println(person.mkString(" "))
}
