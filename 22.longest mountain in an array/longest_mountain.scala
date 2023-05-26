def longestMountain(arr: Array[Int]): Int = {
  val n = arr.length
  var maxLength = 0
  var i = 1

  while (i < n - 1) {
    if (arr(i - 1) < arr(i) && arr(i) > arr(i + 1)) {
      var left = i - 1
      var right = i + 1

      while (left > 0 && arr(left - 1) < arr(left)) {
        left -= 1
      }

      while (right < n - 1 && arr(right) > arr(right + 1)) {
        right += 1
      }

      val currentLength = right - left + 1
      maxLength = maxLength.max(currentLength)
    }

    i += 1
  }

  maxLength
}
