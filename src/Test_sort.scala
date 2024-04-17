import java.io.{FileOutputStream, PrintWriter}

object Test_sort extends App{
  def timed_sort(tab : Array[Int]) : Double = {
    var time = System.nanoTime()
    SelectionSort.sort(tab)
    var end = System.nanoTime()
    return end-time
  }
  var count = 0
  var lign : String = ""
  var text : String = ""
  for(i <- 0 until 3) {
    var taille = 10000*i
    println(s"Taille du tableau : $taille")
    var value : Array[Int] = Array.ofDim(10)
    for(j <- 0 until 10){
      var arr : Array[Int] = RandomArrayFactory.create(taille)
      value(j) = (timed_sort(arr)).toInt
      println(value(j))
      count += 1
    }
    text = text++s"Taille du tableau : $taille; ${value.mkString(";")};\n"
    println(text)
  }
  println(text)
  try {
    val fs = new FileOutputStream("src\\list_arr_sort.csv", true)
    val pw = new PrintWriter(fs)
    pw.print(text)
    pw.close()
    fs.close()
  }
  catch {
    case e: Exception =>
      println("File can't be written")
      e.printStackTrace()
  }
}
