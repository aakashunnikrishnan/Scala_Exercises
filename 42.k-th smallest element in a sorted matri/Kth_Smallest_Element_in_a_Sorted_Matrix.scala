object Solution {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val n = matrix.length
    var low = matrix(0)(0)
    var high = matrix(n - 1)(n - 1)

    while (low < high) {
      val mid = low + (high - low) / 2
      val count = countSmallerOrEqual(matrix, mid)

      if (count < k)
        low = mid + 1
      else
        high = mid
    }

    low
  }

  def countSmallerOrEqual(matrix: Array[Array[Int]], target: Int): Int = {
    val n = matrix.length
    var count = 0
    var row = n - 1
    var col = 0

    while (row >= 0 && col < n) {
      if (matrix(row)(col) <= target) {
        count += row + 1
        col += 1
      } else {
        row -= 1
      }
    }

    count
  }
}
