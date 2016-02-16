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

}
