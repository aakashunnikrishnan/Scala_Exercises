def chalkReplacer(chalk: Array[Int], k: Int): Int = {
  val n = chalk.length
  var remainingChalk = k.toLong

  for (i <- 0 until n) {
    remainingChalk -= chalk(i)

    if (remainingChalk < 0) {
      return i
    }
  }

  chalkReplacer(chalk, (remainingChalk % chalk.sum).toInt)
}
