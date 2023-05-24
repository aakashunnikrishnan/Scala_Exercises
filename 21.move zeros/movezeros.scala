def moveZeroes(nums: Array[Int]): Unit = {
  var left = 0
  var right = 0

  while (left < nums.length) {
    if (nums(left) != 0) {
      val temp = nums(left)
      nums(left) = nums(right)
      nums(right) = temp
      right += 1
    }
    left += 1
  }

  while (right < nums.length) {
    nums(right) = 0
    right += 1
  }
}
