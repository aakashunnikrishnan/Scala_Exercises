object Solution {
  def minAddToMakeValid(s: String): Int = {
    var openCount = 0 // Count of opening parentheses '('
    var closeCount = 0 // Count of closing parentheses ')'

    for (c <- s) {
      if (c == '(') {
        openCount += 1 // Increment opening parentheses count
      } else if (c == ')') {
        if (openCount > 0) {
          openCount -= 1 // Match closing parenthesis with an opening parenthesis
        } else {
          closeCount += 1 // Increment closing parentheses count (unmatched)
        }
      }
    }

    openCount + closeCount // Total moves required is the sum of unmatched opening and closing parentheses
  }
}

