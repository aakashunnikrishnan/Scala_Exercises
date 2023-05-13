def uniquePaths(m: Int, n: Int): Int = {
  val dp = Array.ofDim[Int](m, n)

  // Initialize the first row and first column to 1
  for (i <- 0 until m) dp(i)(0) = 1
  for (j <- 0 until n) dp(0)(j) = 1

  // Calculate the number of unique paths for each cell
  for (i <- 1 until m) {
    for (j <- 1 until n) {
      dp(i)(j) = dp(i-1)(j) + dp(i)(j-1)
    }
  }

  dp(m-1)(n-1) // Return the number of unique paths for the bottom-right cell
}
