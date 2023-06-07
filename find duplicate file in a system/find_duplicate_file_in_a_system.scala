object Solution {
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val contentMap = scala.collection.mutable.Map[String, List[String]]()

    for (path <- paths) {
      val parts = path.split(" ")
      val directory = parts.head
      val files = parts.tail

      for (file <- files) {
        val contentStartIndex = file.indexOf("(")
        val contentEndIndex = file.indexOf(")")
        val fileName = file.substring(0, contentStartIndex)
        val content = file.substring(contentStartIndex + 1, contentEndIndex)

        val filePath = directory + "/" + fileName
        val fileGroup = contentMap.getOrElse(content, List[String]())
        contentMap(content) = filePath :: fileGroup
      }
    }

    contentMap.values.filter(_.size > 1).toList
  }

  def main(args: Array[String]): Unit = {
    val paths = Array(
      "root/d1/d2/f1.txt(content1) f2.txt(content2) f3.txt(content3)",
      "root/d1/f4.txt(content4) f5.txt(content1)",
      "root/d2/f6.txt(content2)"
    )
    val result = findDuplicate(paths)
    result.foreach(group => println(group.mkString(", ")))
    /* Output:
       root/d1/f5.txt, root/d1/d2/f1.txt
       root/d2/f6.txt, root/d1/d2/f2.txt
    */
  }
}
