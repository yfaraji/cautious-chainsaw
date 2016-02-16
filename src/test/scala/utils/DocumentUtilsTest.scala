package utils

import ontrack.utils.DocumentUtils
import org.scalatest.{Matchers, WordSpec}

class DocumentUtilsTest extends WordSpec with Matchers{


  "Ordering a list of strings" should {
    "Output a list in order based on the first character" in {
      val listX = List("xasdf", "sdf", "dfb", "jdgf", "hyt", "dqb")
      val sortedList = List("dfb", "dqb", "hyt", "jdgf", "sdf", "xasdf")
      val dUtils = new DocumentUtils
      dUtils.orderedLines(listX) should be(sortedList)
    }

    "Work with a 1 argument list" in {
      val listX = List("xasdf")
      val sortedList = List("xasdf")
      val dUtils = new DocumentUtils
      dUtils.orderedLines(listX) should be(sortedList)
    }

    "Work with empty list" in {
      val listX = List()
      val sortedList = List()
      val dUtils = new DocumentUtils
      dUtils.orderedLines(listX) should be(sortedList)
    }
  }

  "A word counter" should {
    "Return the correct word count" in {
      val dUtils = new DocumentUtils

      val x = "The quick brown fox jumps over the lazy dog"
      val count = 9
      dUtils.wordCount(x) should be(count)
    }

    "Return the correct word count on empty string" in {
      val dUtils = new DocumentUtils

      val x = ""
      val count = 0
      dUtils.wordCount(x) should be(count)
    }

    "Return the correct word count on 1 word string" in {
      val dUtils = new DocumentUtils

      val x = "isthisoneword"
      val count = 1
      dUtils.wordCount(x) should be(count)
    }


  }
}
