package ontrack.utils

class DocumentUtils {
  def orderedLines(lines: List[String]) =
    lines.sortWith((s1, s2) =>  s2.headOption.fold("")(x=>x.toString) > s1.headOption.fold("")(x=>x.toString))

}
