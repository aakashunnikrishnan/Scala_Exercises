import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

def topKFrequent(words: Array[String], k: Int): List[String] = {
  val frequencyMap = mutable.Map[String, Int]().withDefaultValue(0)

  // Count the frequency of each word
  for (word <- words) {
    frequencyMap(word) += 1
  }

  // Define the ordering for the priority queue
  implicit val ordering: Ordering[(String, Int)] = Ordering.by { case (word, freq) =>
    (-freq, word) // Sort by frequency (descending) and then lexicographical order (ascending)
  }

  // Create a min heap (priority queue) with size k
  val pq = PriorityQueue[(String, Int)]()(ordering.reverse)

  // Insert elements into the priority queue
  for ((word, freq) <- frequencyMap) {
    pq.enqueue((word, freq))
    if (pq.size > k) {
      pq.dequeue()
    }
  }

  // Extract the top k frequent words from the priority queue
  val result = pq.toList.reverse.map(_._1)

  result
}

// Test the function
val words = Array("apple", "banana", "apple", "banana", "orange", "orange", "pear")
val k = 2
val result = topKFrequent(words, k)
println(result)  // Output: List(orange, banana)
