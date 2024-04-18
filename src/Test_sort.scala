import java.io.{FileOutputStream, PrintWriter}

object Test_sort extends App{
  def timed_sort(tab : Array[Int]) : Int = {
    var time = System.currentTimeMillis()
    SelectionSort.sort(tab)
    var end = System.currentTimeMillis()
    return (end-time).toInt
  }

  def timed_sort_Ysort(tab: Array[Int]): Int = {
    var time = System.currentTimeMillis()
    YSort.sort(tab)
    var end = System.currentTimeMillis()
    return (end - time).toInt
  }

  var count = 0
  var res : Array[Int] = Array.ofDim(100)
  var res_invert : Array[Int] = Array.ofDim(100)
  var res_shuffle : Array[Int] = Array.ofDim(100)
  var res_y: Array[Int] = Array.ofDim(100)
  var res_y_invert: Array[Int] = Array.ofDim(100)
  var res_y_shuffle : Array[Int] = Array.ofDim(100)
  for(i <- 1 to 10) {
    var taille = 10000*i
    println(s"Taille du tableau : $taille")
    for(j <- 0 until 10){
      var arr : Array[Int] = RandomArrayFactory.create(taille)
      var arr_invert : Array[Int] = InvertedSortedArrayFactory.create(taille)
      var arr_shuffle : Array[Int] = ShuffleArrayFactory.create(taille)
      res(count) = timed_sort(arr)
      println(res(count))
      res_invert(count) = timed_sort(arr_invert)
      println(res_invert(count))
      res_shuffle(count) = timed_sort(arr_shuffle)
      println(res_shuffle(count))
      res_y(count) = timed_sort_Ysort(arr)
      res_y_invert(count) = timed_sort_Ysort(arr_invert)
      res_y_shuffle(count) = timed_sort_Ysort(arr_shuffle)


      count += 1
    }
  }

  println(res.mkString(","))
  println(res_invert.mkString(","))
  try {
    val fs = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_rand.csv", true)
    val fs_invert = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_invert.csv", true)
    val fs_shuffle = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_shuffle.csv", true)
    val fs_Y = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_rand_y.csv", true)
    val fs_Y_invert = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_invert_y.csv", true)
    val fs_Y_shuffle = new FileOutputStream("C:\\Users\\Natas\\IdeaProjects\\sortedLab_NF\\list_arr_sort_shuffle_y.csv", true)
    val pw = new PrintWriter(fs)
    val pw_invert = new PrintWriter(fs_invert)
    val pw_shuffle = new PrintWriter(fs_shuffle)
    val pw_Y = new PrintWriter(fs_Y)
    val pw_Y_invert = new PrintWriter(fs_Y_invert)
    val pw_Y_shuffle = new PrintWriter(fs_Y_shuffle)
    pw.println(res.mkString(","))
    pw_invert.println(res_invert.mkString(","))
    pw_shuffle.println(res_shuffle.mkString(","))
    pw_Y.println(res_y.mkString(","))
    pw_Y_invert.println(res_y_invert.mkString(","))
    pw_Y_shuffle.println(res_y_shuffle.mkString(","))

    pw.close()
    pw_invert.close()
    pw_shuffle.close()
    pw_Y.close()
    pw_Y_invert.close()
    pw_Y_shuffle.close()
  }
  catch {
    case e: Exception =>
      println("File can't be written")
      e.printStackTrace()
  }
}
