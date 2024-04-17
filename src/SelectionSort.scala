trait Sort{
  def sort(arr : Array[Int]) : Array[Int]
}

object SelectionSort extends Sort{
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