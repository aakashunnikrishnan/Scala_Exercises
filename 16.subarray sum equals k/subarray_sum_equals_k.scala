import scala.collection.mutable.HashMap

def subarraySum(nums: Array[Int], k: Int): Int = {
  var count = 0
  var sum = 0
  val sumMap = HashMap[Int, Int]()

  sumMap.put(0, 1)

  for (num <- nums) {
    sum += num


    if (sumMap.contains(sum - k)) {
      count += sumMap(sum - k)
    }

    
    sumMap(sum) = sumMap.getOrElse(sum, 0) + 1
  }

  count
}
