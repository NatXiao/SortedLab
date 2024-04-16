import scala.util.Random


trait ArrayFactory {
  def create(size: Int): Array[Int]
}

class RandomArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](size)
    var value: Random = new Random(23)
    for (i: Int <- result.indices) {
      result(i) = value.nextInt(size)
    }
    return result
  }
}

class InvertedSortedArrayFactory extends ArrayFactory {
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

class ShuffleArrayFactory extends ArrayFactory {
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


object main extends App {
  val test1 = new RandomArrayFactory
  var test11: Array[Int] = test1.create(14)
  println(test11.mkString(","))

  val test3 = new InvertedSortedArrayFactory
  var test31: Array[Int] = test3.create(14)
  println(test31.mkString(","))

  val test4 = new ShuffleArrayFactory
  var test41: Array[Int] = test4.create(7)
  println(test41.mkString(","))

  val test5 = new AlmostSortedArrayFactory
  var test51: Array[Int] = test5.create(7)
  println(test51.mkString(","))

}
