object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0
    var minPrice = Int.MaxValue

    for (price <- prices) {
      minPrice = Math.min(minPrice, price)
      maxProfit = Math.max(maxProfit, price - minPrice)
    }

    maxProfit
  }
}
