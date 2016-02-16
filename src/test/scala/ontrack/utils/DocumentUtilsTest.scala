package ontrack.utils

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

  "Sentence counter" should {
    "Return the correct sentence count" in {
      val dUtils = new DocumentUtils

      val x = "Cheeseburger! Are you a burrito? What a shame."
      val count = 3
      dUtils.sentenceCount(x) should be(count)
    }

    "Return the correct sentence count on empty sentence" in {
      val dUtils = new DocumentUtils

      val x = ""
      val count = 0
      dUtils.sentenceCount(x) should be(count)
    }

    "Return the correct sentence count on sentence that does not end in punctuation" in {
      val dUtils = new DocumentUtils

      val x = "is this a sentence without a question mark"
      val count = 1
      dUtils.sentenceCount(x) should be(count)
    }

    "Return the correct sentence count on sentence that does end in punctuation." in {
      val dUtils = new DocumentUtils

      val x = "is this a sentence without a question mark"
      val count = 1
      dUtils.sentenceCount(x) should be(count)
    }
  }
}
