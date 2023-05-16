import scala.collection.mutable.HashMap

def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
  val freqMap = HashMap[Int, Int]()

  for (num <- nums1) {
    freqMap(num) = freqMap.getOrElse(num, 0) + 1
  }

  val result = scala.collection.mutable.ArrayBuffer[Int]()

  for (num <- nums2) {
    if (freqMap.contains(num) && freqMap(num) > 0) {
      result += num
      freqMap(num) -= 1
    }
  }

  result.toArray
}
