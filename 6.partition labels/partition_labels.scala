def partitionLabels(s:String):List[Int] = {
  val lastindices = Array.fill(26)(-1)
  for (i<-s.indices){
    lastindices(s(i)-'a')=i
  }
  var start = 0
  var end = 0
  var partitions = List.empty[Int]
  for (i <- s.indices){
    end = math.max(end,lastindices(s(i)-'a'))
    if (i==end){
      partitions ::= (end-start+1)
      start = end+1
    }
  }
partitions.reverse
}


val s = "ababcbacadefegdehijhklij"
val res = partitionLabels(s)
println(res)