import scala.collection.mutable

object Solution {
  def isPossible(nums: Array[Int]): Boolean = {
    val countMap = mutable.Map.empty[Int, Int] // Map to store the count of each number
    val appendMap = mutable.Map.empty[Int, Int] // Map to store the count of subsequences that can be appended with each number

    for (num <- nums) {
      countMap(num) = countMap.getOrElse(num, 0) + 1
    }

    for (num <- nums) {
      if (countMap(num) == 0) {
        // Skip if the number is already used in a subsequence
        // This ensures that we are always appending to the previous subsequence when possible
        continue
      } else if (appendMap.getOrElse(num, 0) > 0) {
        // Append the number to a previous subsequence
        appendMap(num) -= 1
        appendMap(num + 1) = appendMap.getOrElse(num + 1, 0) + 1
      } else if (countMap.getOrElse(num + 1, 0) > 0 && countMap.getOrElse(num + 2, 0) > 0) {
        // Start a new subsequence
        countMap(num + 1) -= 1
        countMap(num + 2) -= 1
        appendMap(num + 3) = appendMap.getOrElse(num + 3, 0) + 1
      } else {
        // Cannot form a subsequence
        return false
      }

      countMap(num) -= 1 // Reduce the count of the current number
    }

    true
  }
}
