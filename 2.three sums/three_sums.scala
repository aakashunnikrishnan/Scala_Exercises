def threeSums(nums:Array[Int]):List[List[Int]] = {
  val n = nums.length
  val sortedNums = nums.sorted
  var res = List[List[Int]]()
  for(i<-0 until n-2){
    if (i==0 || sortedNums(i)!=sortedNums(i-1)){
      var j = i+1
      var k = n-2
      while (j<k){
        val sum = sortedNums(i)+sortedNums(j)+sortedNums(k)
        if (sum == 0){
          res = res:+List(sortedNums(i),sortedNums(j),sortedNums(k))
          while(j<k && sortedNums(j)==sortedNums(j+1)) j+=1
          while (j<k && sortedNums(k)==sortedNums(k-1)) k-=1
          j+=1
          k-=1
        }
        else if (sum<0){
          j+=1
        }
        else{
          k-=1
        }
      }
    }
  }
  res
}


val arr = Array(-1,0,1,2,-1,-4)
val res = threeSums(arr)
println(res)