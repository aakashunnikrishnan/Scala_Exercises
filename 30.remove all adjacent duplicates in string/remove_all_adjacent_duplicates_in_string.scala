object Solution {
  def removeDuplicates(s: String): String = {
    val stack = collection.mutable.Stack[Char]()

    for (c <- s) {
      if (stack.isEmpty || stack.top != c) {
        stack.push(c)
      } else {
        stack.pop()
      }
    }

    stack.mkString.reverse
  }
}