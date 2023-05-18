import scala.collection.mutable.Map

def balancedString(s: String): Int = {
  val n = s.length
  val targetCount = n / 4

  var minLen = n
  var start = 0

  val countMap = Map[Char, Int]()

  for (ch <- s) {
    countMap(ch) = countMap.getOrElse(ch, 0) + 1
  }

  for (end <- 0 until n) {
    countMap(s(end)) -= 1

    while (start < n && countMap.values.forall(_ <= targetCount)) {
      minLen = math.min(minLen, end - start + 1)
      countMap(s(start)) += 1
      start += 1  
    }
  }

  minLen
}
