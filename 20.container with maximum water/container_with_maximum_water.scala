def maxArea(height: Array[Int]): Int = {
  var left = 0
  var right = height.length - 1
  var maxArea = 0

  while (left < right) {
    val currArea = Math.min(height(left), height(right)) * (right - left)
    maxArea = Math.max(maxArea, currArea)

    if (height(left) < height(right))
      left += 1
    else
      right -= 1
  }

  maxArea
}
