import Test_sort.timed_sort

object mainTest20 extends App {

  def dicho(quoi: Int): Int = {

    var temps: Double = 0
    val tempsRef: Double = math.pow(10, 3)
    var tailleMax: Int = 70000
    var tailleMin: Int = 0
    var taille: Int = (math.random() * tailleMax).toInt

    while (temps < tempsRef * 0.9 || temps > tempsRef * 1.1) {
      var arr: Array[Int] = new Array[Int](taille)
      quoi match {
        case 1 => {
          arr = RandomArrayFactory.create(taille)
          temps = timed_sort(arr)
        }
      }

      if (temps < tempsRef * 0.9) {
        var sauv1: Int = taille
        taille = tailleMax - (tailleMax - tailleMin) / 2
        tailleMin = sauv1
      }
      else if (temps > tempsRef * 1.1) {
        var sauv2: Int = taille
        taille = tailleMin + (tailleMax - tailleMin) / 2
        tailleMax = sauv2
      }

    }
    return taille
  }

  println(timed_sort(RandomArrayFactory.create(40000)))


var testValue : Int = dicho(1)
println(testValue)
println(timed_sort(RandomArrayFactory.create(testValue)))

}