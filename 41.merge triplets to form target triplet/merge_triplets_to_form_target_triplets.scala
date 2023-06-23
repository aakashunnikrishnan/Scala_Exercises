object Solution {
  def mergeTriplets(triplets: Array[Array[Int]], target: Array[Int]): Boolean = {
    var possible = Array.fill(3)(0)

    for (triplet <- triplets) {
      if (triplet(0) <= target(0) && triplet(1) <= target(1) && triplet(2) <= target(2)) {
        possible(0) = math.max(possible(0), triplet(0))
        possible(1) = math.max(possible(1), triplet(1))
        possible(2) = math.max(possible(2), triplet(2))
      }
    }

    possible(0) == target(0) && possible(1) == target(1) && possible(2) == target(2)
  }
}
