def maxArea(h: Int, w: Int, horizontalCuts: Array[Int], verticalCuts: Array[Int]): Int = {
  val mod = (1e9 + 7).toInt

  val sortedHorizontalCuts = (0 +: horizontalCuts.sorted :+ h)
  val sortedVerticalCuts = (0 +: verticalCuts.sorted :+ w)

  val maxHorizontal = sortedHorizontalCuts
    .sliding(2)
    .map { case Array(a, b) => b - a }
    .max

  val maxVertical = sortedVerticalCuts
    .sliding(2)
    .map { case Array(a, b) => b - a }
    .max

  val maxArea = (maxHorizontal.toLong * maxVertical.toLong) % mod

  maxArea.toInt
}
