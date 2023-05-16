import scala.collection.mutable.ArrayBuffer

def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
  val sortedNums1 = nums1.sorted
  val sortedNums2 = nums2.sorted

  val result = ArrayBuffer[Int]()

  var i = 0
  var j = 0

  while (i < sortedNums1.length && j < sortedNums2.length) {
    if (sortedNums1(i) < sortedNums2(j)) {
      i += 1
    } else if (sortedNums1(i) > sortedNums2(j)) {
      j += 1
    } else {
      result += sortedNums1(i)
      i += 1
      j += 1
    }
  }

  result.toArray
}
