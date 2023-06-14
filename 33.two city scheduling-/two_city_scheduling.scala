object Solution {
  def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
    val n = costs.length / 2

    // Sort the costs based on the difference between aCost and bCost
    val sortedCosts = costs.sortBy(cost => cost(0) - cost(1))

    var totalCost = 0

    // Fly the first n people to city A and the rest to city B
    for (i <- 0 until n) {
      totalCost += sortedCosts(i)(0) // Add the cost of flying to city A
      totalCost += sortedCosts(i + n)(1) // Add the cost of flying to city B
    }

    totalCost
  }
}
