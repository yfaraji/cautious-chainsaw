package ontrack.utils

import java.io.{BufferedWriter, File, FileWriter}

import scala.collection.mutable.ListBuffer

//Ideally have DI in place or cake pattern to make this testable
object InputOutput {

  def readFileIn(pathAndFile: String) = {
    import scala.io.Source
    val listBuf:ListBuffer[String] = ListBuffer()
    for(line <- Source.fromFile(new File(pathAndFile), "UTF-8").getLines()) {
      if (line.nonEmpty) {listBuf += line}
    }
    listBuf.toList
  }

  def writeOut(lines: List[String], pathAndFile: String) = {
    def addNewLines(bw: BufferedWriter, lines:List[String]) {
      if (lines.headOption.isDefined && lines.tail.isEmpty) {
        bw.write(lines.headOption.getOrElse(""))
      } else {
        bw.write(lines.headOption.getOrElse("") ++ "\n\n")
        addNewLines(bw, lines.tail)
      }
    }


    val file = new File(pathAndFile)
    val bw = new BufferedWriter(new FileWriter(file))
    addNewLines(bw, lines)
    bw.close()
  }

  def createFileName(pathAndFileName: String) = {
    val x = pathAndFileName.splitAt(pathAndFileName.length - 4)
    x._1 ++ "-1" ++ x._2
  }

}
