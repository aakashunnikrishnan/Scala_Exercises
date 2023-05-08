def longestCommonPrefix(strs: Array[String]): String = {
  if (strs.isEmpty) {
    return ""
  }

  val prefix = strs.head
  var i = 0

  while (i < prefix.length) {
    val c = prefix.charAt(i)

    for (str <- strs.tail) {
      if (i >= str.length || str.charAt(i) != c) {
        return prefix.substring(0, i)
      }
    }

    i += 1
  }

  prefix
}

val arr = Array("flower","flow","flight")
val res = longestCommonPrefix(arr)
println(res)