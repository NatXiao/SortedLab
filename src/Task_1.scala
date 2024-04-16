import scala.util.Random


trait ArrayFactory {

  def create(size : Int) : Array[Int]


}

object RandomArrayFactory extends ArrayFactory {

  override def create(size: Int): Array[Int] = {

    var result = new Array[Int](size)

    for(i : Int <- result.indices){

      result(i) = new Random(32).nextInt()

    }

    return result

  }


}