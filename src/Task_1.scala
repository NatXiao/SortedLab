import scala.util.Random


trait ArrayFactory {
  def create(size: Int): Array[Int]
}

object RandomArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](size)
    var value: Random = new Random(23)
    for (i: Int <- result.indices) {
      result(i) = value.nextInt(size)
    }
    return result
  }
}

object InvertedSortedArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](size)
    var value: Int = size - 1
    for (i: Int <- result.indices) {
      result(i) = value
      value -= 1
    }
    return result
  }
}

object ShuffleArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](size)
    var valueDown: Int = size - 1
    var valueUp: Int = 0
    for (i: Int <- result.indices) {
      if (i % 2 == 1 && i != 0) {
        result(i) = valueDown
        valueDown -= 1
      }
      else {
        result(i) = valueUp
        valueUp += 1
      }
    }
    return result
  }
}

class AlmostSortedArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](size)
    val ratio: Int = 30 * size / 100
    var valueR: Random = new Random(23)
    var value: Int = 0
    for (i: Int <- result.indices) {
      if (value <= ratio) {
        result(i) = valueR.nextInt(size)
        value += 1
      }
      else {
        result(i) = i
      }
          }
    return result
  }
}


