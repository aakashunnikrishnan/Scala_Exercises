def isValidSudoku(board: Array[Array[Char]]): Boolean = {
  val rows = Array.ofDim[Boolean](9, 9)
  val cols = Array.ofDim[Boolean](9, 9)
  val boxes = Array.ofDim[Boolean](9, 9)

  for (i <- 0 until 9) {
    for (j <- 0 until 9) {
      if (board(i)(j) != '.') {
        val num = board(i)(j) - '1'
        val boxIndex = (i / 3) * 3 + (j / 3)

        if (rows(i)(num) || cols(j)(num) || boxes(boxIndex)(num)) {
          return false
        }

        rows(i)(num) = true
        cols(j)(num) = true
        boxes(boxIndex)(num) = true
      }
    }
  }

  true
}
