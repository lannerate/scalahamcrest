package org.scalahamcrest.oo

import Asserter.assertThat
import org.scalatest.{FunSpec, Matchers}

class MatcherSpec extends FunSpec with Matchers {
  describe("EqualTo") {
    assertThat(2, EqualTo(2))
    assertThat(2, Is(2))
  }

  describe("Not EqualTo") {
    assertThat(1, Not(EqualTo(2)))
    assertThat(1, !EqualTo(2))
    assertThat(1, Not(2))
  }

  describe("InstanceOf") {
    assertThat(2, InstanceOf[Int])
    assertThat(2, Not(InstanceOf[String]))
    assertThat(2, !InstanceOf[String])

    assertThat("string", InstanceOf[String])
    assertThat("string", !InstanceOf[Int])

    assertThat(Nil, InstanceOf[List[_]])
    assertThat(None, InstanceOf[Option[_]])
  }

  describe("Same") {
    assertThat("horance", Same("horance"))
  }

  describe("AnyOf") {
    assertThat(2, AnyOf(Never, Not(2), !EqualTo(2), EqualTo(2)))
    assertThat(2, Never || Not(2) || !EqualTo(2) || EqualTo(2))
  }

  describe("AllOf") {
    assertThat(2, AllOf(Always, InstanceOf[Int], Is(2), EqualTo(2)))
    assertThat(2, Always && InstanceOf[Int] && Is(2) && EqualTo(2))
  }

  describe("StringOps") {
    assertThat("horance", EqualTo("horance"))
    assertThat("horance liu", Starts("horance"))
    assertThat("horance liu", Ends("liu"))
    assertThat("horance liu", Contains("horance"))
  }

  describe("StringOps: IgnoringCase") {
    assertThat("horance", IgnoringCase equalTo "HORANCE")
    assertThat("horance liu", IgnoringCase starts "HORANCE")
    assertThat("horance liu", IgnoringCase ends "LIU")
    assertThat("horance liu", IgnoringCase contains "HORANCE")
  }

  describe("Comparations") {
    assertThat(2, LessThan(3))
    assertThat(2, GreaterThan(1))

    assertThat(2, GreaterThanOrEqualTo(1))
    assertThat(2, GreaterThanOrEqualTo(2))

    assertThat(2, LessThanOrEqualTo(3))
    assertThat(2, LessThanOrEqualTo(2))
    assertThat(2, ComparesEqualTo(2))
  }

  describe("BlankOrNil") {
    assertThat("  ", Blank)
    assertThat(null, BlankOrNil)
  }

  describe("EmptyOrNil") {
    assertThat("", Empty)
    assertThat(null, EmptyOrNil)
  }
}
