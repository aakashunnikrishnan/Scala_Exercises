object Solution {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    val freq = Array.fill(100001)(0) // Create an array to store the frequency of each ice cream bar price

    for (cost <- costs)
      freq(cost) += 1 // Count the frequency of each ice cream bar price

    var count = 0 // Variable to count the number of ice cream bars the boy can buy
    var remainingCoins = coins // Variable to track the remaining coins

    for (i <- freq.indices) {
      val numIceCreams = Math.min(freq(i), remainingCoins / i) // Determine the maximum number of ice cream bars that can be bought at price i

      count += numIceCreams // Increment the count of ice cream bars

      remainingCoins -= numIceCreams * i // Update the remaining coins

      if (remainingCoins == 0)
        return count // If all coins have been spent, return the count of ice cream bars
    }

    count // Return the count of ice cream bars
  }
}
