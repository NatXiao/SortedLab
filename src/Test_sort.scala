import java.io.{FileOutputStream, PrintWriter}

object Test_sort extends App{
  def timed_sort(tab : Array[Int]) : Double = {
    var time = System.nanoTime()
    SelectionSort.sort(tab)
    var end = System.nanoTime()
    return end-time
  }
  var count = 0
  var res : Array[Double] = Array.ofDim(100)
  for(i <- 0 until 10) {
    var taille = 10000*i
    println(s"Taille du tableau : $taille")
    for(j <- 0 until 10){
      var arr : Array[Int] = RandomArrayFactory.create(taille)
      println(timed_sort(arr))
      res(count) = timed_sort(arr)
      count += 1
    }
  }
  try {
    val fs = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort.csv", true)
    val pw = new PrintWriter(fs)
    pw.print(res.mkString(","))
  }
  catch {
    case e: Exception =>
      println("File can't be written")
      e.printStackTrace()
  }
}
