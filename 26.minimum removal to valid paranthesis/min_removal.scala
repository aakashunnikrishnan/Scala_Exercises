import scala.collection.mutable.Stack

object Solution {
  def removeInvalidParentheses(s: String): String = {
    val stack = Stack[Int]()
    val sb = new StringBuilder()

    for (i <- s.indices) {
      val c = s(i)
      if (c == '(') {
        stack.push(i)
      } else if (c == ')') {
        if (stack.nonEmpty) {
          stack.pop()
        } else {
          sb.append("")
        }
      }
      sb.append(c)
    }

    while (stack.nonEmpty) {
      val index = stack.pop()
      sb.replace(index, index + 1, "")
    }

    sb.toString()
  }

  def main(args: Array[String]): Unit = {
    val s = "(()())())"
    val result = removeInvalidParentheses(s)
    println(result)  // Output: (()())
  }
}
