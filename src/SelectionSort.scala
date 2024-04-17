trait Sort{
  def sort(arr : Array[Int]) : Array[Int]
}

object SelectionSort extends Sort{
  override def sort(arr: Array[Int]): Array[Int] = {
    for(j : Int <- arr.indices) {
      var min: Int = arr(j)
      for(i : Int <- j until arr.length){
        if(arr(i) < min){
          var change : Int = min
          min = arr(i)
          arr(i) = change
        }
      }
      arr(j) = min
    }
    return arr
  }
}