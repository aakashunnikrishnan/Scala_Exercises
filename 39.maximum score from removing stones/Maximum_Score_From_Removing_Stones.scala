object Solution {
  def maximumScore(a: Int, b: Int, c: Int): Int = {
    val piles = Array(a, b, c)
    piles.sorted

    var score = 0
    while (piles(1) > 0) {
      piles(2) -= 1
      piles(1) -= 1
      score += 1
      piles.sorted
    }

    score
  }
}
