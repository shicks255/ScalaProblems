package Fundamentals.TraitPractice.DatabaseInjectionPractice

object Runner extends App{
  val dbService: MyTestService[Int] = MyTestService[Int]
  dbService.drop(4)
  dbService.query()
  dbService.add(3)
  dbService.checkInventory

  val postgresService: MyPostGresTestService[String] = MyPostGresTestService[String]
  postgresService.drop("one")
  postgresService.query()
  postgresService.add("three")
  postgresService.checkInventory
}

case class MyTestService[A]() extends Service[A]
case class MyPostGresTestService[A]() extends PostgresService[A]

trait Service[A] extends Inventory[A] with Datastore[A] {
  override val database: DatabaseImp[A] = new DatabaseImp[A]
}
trait PostgresService[A] extends Inventory[A] with Datastore[A] {
  override val database: PostGresDatabaseImp[A] = new PostGresDatabaseImp[A]
}

trait Inventory[A] {
  val database: DatabaseService[A]

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
  val database: DatabaseService[A]

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
case class PostGresDatabaseImp[A]() extends DatabaseService[A] {
  override def add[A](a: A): Unit = {
    println("adding to psotgres" + a)
  }
  override def query[A](): Option[A] = {
    println("querying for postgres")
    None
  }
  override def drop[A](a: A): Unit = {
    println("removing " + a + " from postgres database")
  }
}

trait DatabaseService[A] {
  def add[A](a: A)
  def query[A](): Option[A]
  def drop[A](a: A)
}
