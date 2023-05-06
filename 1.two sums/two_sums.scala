def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  val seen = scala.collection.mutable.Map.empty[Int, Int]
  for ((value, index) <- nums.zipWithIndex) {
    val complement = target - value
    if (seen.contains(complement)) {
      return Array(seen(complement), index)
    }
    seen(value) = index
  }
  throw new IllegalArgumentException("No two elements add up to the target")
}
