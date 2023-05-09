def canJump(nums:Array[Int]):Boolean = {
  var maxReach = 0
  for (i<-nums.indices){
    if(maxReach<i){
      return false
    }
    maxReach = Math.max(maxReach,i+nums(i))
  }
  true
}

val nums = Array(3,2,1,0,4)
val res = canJump(nums)
println(res)