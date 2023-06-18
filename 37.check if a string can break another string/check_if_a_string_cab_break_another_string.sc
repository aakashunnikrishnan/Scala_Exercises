object Solution {
  def checkIfCanBreak(s1: String, s2: String): Boolean = {
    val sortedS1 = s1.sorted // Sort string s1 in alphabetical order
    val sortedS2 = s2.sorted // Sort string s2 in alphabetical order

    var s1CanBreak = true // Flag to indicate if s1 can break s2
    var s2CanBreak = true // Flag to indicate if s2 can break s1

    for (i <- 0 until s1.length) {
      if (sortedS1(i) < sortedS2(i))
        s1CanBreak = false // If s1[i] < s2[i], s1 cannot break s2

      if (sortedS2(i) < sortedS1(i))
        s2CanBreak = false // If s2[i] < s1[i], s2 cannot break s1

      if (!s1CanBreak && !s2CanBreak)
        return false // If neither s1 can break s2 nor s2 can break s1, return false
    }

    true // If either s1 can break s2 or s2 can break s1, return true
  }
}