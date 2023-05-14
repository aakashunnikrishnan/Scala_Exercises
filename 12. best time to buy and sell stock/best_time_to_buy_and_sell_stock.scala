def maxProfit(prices: Array[Int], fee: Int): Int = {
  var cash = 0
  var hold = -prices(0)

  for (i <- 1 until prices.length) {
    val prevCash = cash
    cash = Math.max(cash, hold + prices(i) - fee)
    hold = Math.max(hold, prevCash - prices(i))
  }

  cash
}
