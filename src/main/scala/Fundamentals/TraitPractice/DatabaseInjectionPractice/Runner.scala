package Fundamentals.TraitPractice.DatabaseInjectionPractice

object Runner extends App{

  val dbService: MyTestService[Int] = MyTestService[Int]
  dbService.drop(4)
  dbService.query()
  dbService.add(3)
  dbService.checkInventory
}

case class MyTestService[A]() extends Service[A]

trait Service[A] extends Inventory[A] with Datastore[A] {
  override val database: DatabaseImp[A] = new DatabaseImp[A]
}

trait Inventory[A] {
  val database: DatabaseImp[A]

  def checkInventory = {
    val result = database.query()
    result match {
      case None => println("nothing in stock")
      case _ => println("Error occured")
    }
  }
}

trait Datastore[A] {
  //dependency injection
  val database: DatabaseImp[A]

  def add(a: A) = database.add(a)
  def query() = database.query()
  def drop(a: A) = database.drop(a)
}

case class DatabaseImp[A]() extends DatabaseService[A] {
  override def add[A](a: A): Unit = {
    println("adding " + a)
  }
  override def query[A](): Option[A] = {
    println("querying for ")
    None
  }
  override def drop[A](a: A): Unit = {
    println("removing " + a + " from database")
  }
}

trait DatabaseService[A] {
  def add[A](a: A)
  def query[A](): Option[A]
  def drop[A](a: A)
}
