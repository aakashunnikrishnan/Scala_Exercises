object Solution {
  def isSubsequence(s: String, t: String): Boolean = {
    var sIndex = 0
    var tIndex = 0

    while (sIndex < s.length && tIndex < t.length) {
      if (s(sIndex) == t(tIndex)) {
        sIndex += 1
      }
      tIndex += 1
    }

    sIndex == s.length
  }
}