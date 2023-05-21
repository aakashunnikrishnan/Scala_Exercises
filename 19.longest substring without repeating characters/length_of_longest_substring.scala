import scala.collection.mutable

def length_of_longest_substring(s: String):Int = {
  val n = s.length
  var maxLength = 0
  var start = 0
  var end = 0
  val seen = mutable.HashSet[Char]()

  while (end < n) {
    val char = s.charAt(end)
    if (!seen.contains(char)){
      seen.add(char)
      val length = end - start +1
      maxLength = math.max(maxLength,length)
      end += 1
    }
    else{
      seen.remove(s.charAt(start))
      start += 1
    }
  }
  maxLength
}
