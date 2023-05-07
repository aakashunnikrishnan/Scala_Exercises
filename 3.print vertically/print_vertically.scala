def printVertically(s:String):List[Char] = {
  val words = s.split(" ")
  val maxLength = words.map(_.length).max
  val result = Array.fill(maxLength)(" ")
  for (i <- 0 until maxLength) {
    for (word <- words.indices) {
      if (i < words(word).length) {
        result(i) += words(word)(i)
      } else {
        result(i) += " "
      }
    }
  }
    result.map(_.replaceAll("\\s+$"," ").toList)
}


  val s = "Good morning"
  val res = printVertically(s)
  println(res)