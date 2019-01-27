package eyrie.ops

import eyrie.instances.DescendantByInputInstances
import simulacrum.typeclass

trait Descendant[A, B] {
  def root: A => B
}

object Descendant {
  @inline
  def apply[A, B](implicit A: Descendant[A, B]): Descendant[A, B] = A


  @typeclass
  trait ByInput[A] {
    type Root

    def root: A => Root
  }

  object ByInput extends DescendantByInputInstances {
    type Aux[A, B] = ByInput[A] {
      type Root = B
    }
  }
}
