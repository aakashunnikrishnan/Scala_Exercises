def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
  var minLength = Int.MaxValue
  var left = 0
  var sum = 0

  for (right <- nums.indices) {
    sum += nums(right)

    while (sum >= target) {
      minLength = minLength.min(right - left + 1)
      sum -= nums(left)
      left += 1
    }
  }

  if (minLength == Int.MaxValue) 0 else minLength
}
