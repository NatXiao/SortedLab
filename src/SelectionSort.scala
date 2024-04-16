trait Sort{
  def sort(arr : Array[Int]) : Array[Int]
}

class SelectionSort extends Sort{
  override def sort(arr: Array[Int]): Array[Int] = {
    var res : Array[Int] = Array.ofDim(arr.length)
    for(j : Int <- res.indices) {
      var min: Int = arr(j)
      for(i : Int <- j until arr.length){
        if(arr(i) < min){
          var change : Int = min
          min = arr(i)
          arr(i) = change
        }
      }
      res(j) = min
    }
    return res
  }
}

object main extends App{
  val test = new SortApplication
  val selectSort = new SelectionSort
  test.displayArray(selectSort.sort(Array( 5, 3, 2, 8, 1)))
}