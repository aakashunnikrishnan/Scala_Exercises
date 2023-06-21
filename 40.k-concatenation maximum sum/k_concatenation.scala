object Solution {
  def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
    val mod = (1e9 + 7).toInt
    val n = arr.length

    def maxSubArraySum(nums: Array[Int]): Int = {
      var maxSum = 0
      var currentSum = 0

      for (num <- nums) {
        currentSum = math.max(num, currentSum + num)
        maxSum = math.max(maxSum, currentSum)
      }

      maxSum
    }

    val sumArr = arr.sum
    val maxSubArrSum = maxSubArraySum(arr)
    val maxPrefixSum = maxSubArraySum(arr.indices.map(i => arr(i % n)).toArray)
    val maxSuffixSum = maxSubArraySum(arr.indices.map(i => arr((n - i - 1) % n)).toArray)

    if (k == 1) maxSubArrSum % mod
    else if (sumArr <= 0) math.max(maxSubArrSum, (maxPrefixSum + maxSuffixSum) % mod)
    else ((maxPrefixSum.toLong + maxSuffixSum.toLong + (k.toLong - 2) * sumArr.toLong) % mod).toInt
  }
}
