object Solution {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val sortedNums = nums.sorted
    var closestSum = sortedNums(0) + sortedNums(1) + sortedNums(2)

    for (i <- 0 until sortedNums.length - 2) {
      var left = i + 1
      var right = sortedNums.length - 1

      while (left < right) {
        val sum = sortedNums(i) + sortedNums(left) + sortedNums(right)

        if (sum == target) {
          return sum
        }

        if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
          closestSum = sum
        }

        if (sum < target) {
          left += 1
        } else {
          right -= 1
        }
      }
    }

    closestSum
  }
}
