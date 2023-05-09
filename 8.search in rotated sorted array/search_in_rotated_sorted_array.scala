def search(nums:Array[Int],target:Int):Int = {
  var left = 0
  var right = nums.length - 1
  while (left <= right){
    val mid = left+(right-left)/2
    if (nums(mid)==target){
      return mid
    }
    if (nums(mid)>=nums(left)){
      if (target>=nums(left) && target<nums(mid)){
        right = mid - 1
      }
      else{
        left = mid + 1
      }}
      else{
      if (target<= nums(right) && target>nums(mid)){
        left = mid+1
      }
      else{
        right = mid-1
      }


    }
  }
  -1
}

val nums = Array(4,5,6,7,0,1,2)
val target = 0
val res = search(nums,target)
println(res)