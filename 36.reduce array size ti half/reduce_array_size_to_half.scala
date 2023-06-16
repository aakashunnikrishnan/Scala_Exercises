object Solution {
  def minSetSize(arr: Array[Int]): Int = {
    val freqMap = arr.groupBy(identity).mapValues(_.length) // Count the frequency of each integer
    val sortedFreq = freqMap.values.toList.sorted.reverse // Sort the frequencies in descending order
    var count = 0 // Count of removed integers
    var removedCount = 0 // Total count of integers removed
    var i = 0 // Index for iterating over the sorted frequencies

    while (removedCount < arr.length / 2) {
      count += 1 // Add the current frequency to the set
      removedCount += sortedFreq(i) // Add the count of removed integers
      i += 1 // Move to the next frequency
    }

    count // Return the minimum size of the set
  }
}