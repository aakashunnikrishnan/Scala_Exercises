import scala.collection.mutable.Stack

object Solution {
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val result = Array.fill(n)(-1)
    val stack = Stack[Int]()

    // Traverse the array twice to handle the circular property
    for (i <- 0 until n * 2) {
      val num = nums(i % n)
      while (stack.nonEmpty && nums(stack.top) < num) {
        result(stack.pop()) = num
      }
      if (i < n) {
        stack.push(i)
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(3, 4, 5, 2, 1)
    val result = nextGreaterElements(nums)
    println(result.mkString(", ")) // Output: 4, 5, -1, 3, 3
  }
}
