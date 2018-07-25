package Fundamentals

object FunctionStuff extends App{

  val by5 = makeMultiplier(5)
  println(by5(10))

  val kittyNamer = animalNamer("cat")
  val doggyNamer = animalNamer("dog")

  println(kittyNamer("boo"))
  println(doggyNamer("brandy"))
  println(doggyNamer("mushi"))


  def animalNamer(animalTpe :String) = {
    (name :String) => (s"${name} ${animalTpe}")
  }

  def makeMultiplier(factor :Int) = {
    (x: Int) => factor * x
  }


}
