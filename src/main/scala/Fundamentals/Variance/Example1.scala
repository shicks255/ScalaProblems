package Fundamentals.Variance

class Grandparent
class Parent extends Grandparent
class Child extends Parent

case class InvariantClass[A]()
case class CovariantClass[+A]()
case class ContravariantClass[-A]()

object Example1 extends App{

  def invariantMethod(x: InvariantClass[Parent]) {}
  def covariantMethod(x: CovariantClass[Parent]) {}
  def contraVariantMethod(x: ContravariantClass[Parent]) {}

//  invariantMethod(InvariantClass[Child])
//  invariantMethod(InvariantClass[Parent])
//  invariantMethod(InvariantClass[Grandparent])
//
//  covariantMethod(CovariantClass[Child])
//  covariantMethod(CovariantClass[Parent])
//  covariantMethod(CovariantClass[Grandparent])
//
//  contraVariantMethod(ContravariantClass[Child])
//  contraVariantMethod(ContravariantClass[Parent])
//  contraVariantMethod(ContravariantClass[Grandparent])
}
