import scala.collection.mutable.Stack

object Solution {
  def scoreOfParentheses(s: String): Int = {
    val stack = Stack[Int]()
    var score = 0

    for (c <- s) {
      if (c == '(') {
        stack.push(score)
        score = 0
      } else {
        score = stack.pop() + Math.max(score * 2, 1)
      }
    }

    score
  }

  def main(args: Array[String]): Unit = {
    val s = "(()(()))"
    val result = scoreOfParentheses(s)
    println(result)  // Output: 6
  }
}
