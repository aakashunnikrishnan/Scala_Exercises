import scala.collection.mutable

def smallestRange(nums: Array[Array[Int]]): Array[Int] = {
  val k = nums.length
  val pointers = Array.fill(k)(0)
  val minHeap = mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by(_._1))

  var minRangeStart = Int.MinValue
  var minRangeEnd = Int.MaxValue
  var maxValue = Int.MinValue

  for (i <- 0 until k) {
    val value = nums(i)(0)
    minHeap.enqueue((value, i, 0))
    maxValue = math.max(maxValue, value)
  }

  while (minHeap.nonEmpty) {
    val (currValue, listIndex, index) = minHeap.dequeue()
    val range = maxValue - currValue

    if (range < minRangeEnd - minRangeStart || (range == minRangeEnd - minRangeStart && currValue < minRangeStart)) {
      minRangeStart = currValue
      minRangeEnd = maxValue
    }

    if (index + 1 < nums(listIndex).length) {
      val nextValue = nums(listIndex)(index + 1)
      minHeap.enqueue((nextValue, listIndex, index + 1))
      maxValue = math.max(maxValue, nextValue)
    } else {
      break
    }
  }

  Array(minRangeStart, minRangeEnd)
}
