package ontrack

import ontrack.utils.{InputOutput, DocumentUtils}

object App{

  def main(args: Array[String]) = {
    if (args.isEmpty) {
      println("Need atleast one argument")
      System.exit(0);
    }

    val sUtils = new DocumentUtils

    val fileAndName = args(0)

    val fileIn = InputOutput.readFileIn(fileAndName)

    fileIn.foreach(x => println(s"For sentence: \n\n$x\n\nThere is a word count of ${sUtils.wordCount(x)}.\n\n" +
      s"There is a sentence count of ${sUtils.sentenceCount(x)}\n\n"))

    InputOutput.writeOut(sUtils.orderedLines(fileIn), InputOutput.createFileName(fileAndName))


  }
}
