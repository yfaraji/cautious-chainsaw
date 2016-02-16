package ontrack.utils

class DocumentUtils {

  val listOfSentenceEndings = Array('.', '!', '?', '…')


  def orderedLines(lines: List[String]) =
    lines.sortWith((s1, s2) =>  s2.headOption.fold("")(x=>x.toString) > s1.headOption.fold("")(x=>x.toString))

  def wordCount(line: String) = {
    line match {
      case x if x.isEmpty => 0
      case x if !x.contains(" ") => 1
      case _ => line.split(" ").length
    }
  }

  def sentenceCount(line: String) =
    line match {
      case x if x.isEmpty => 0
      case x if x.filter(y => listOfSentenceEndings.contains(y)).isEmpty => 1
      case _ => line.split(listOfSentenceEndings).length
    }


}
