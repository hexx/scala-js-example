package com.github.hexx

import scalaz._, Scalaz._

trait JQueryStatic extends js.Object {
  def apply(selector: String): JQueryStatic
  def append(content: String): Unit
}

object importedjs extends js.GlobalScope {
  var jQuery: JQueryStatic = _
}

object Main {
  def main(): Unit = {
    importedjs.jQuery("#playground").append(s"""<p>${List("Hello", "by", "Static").shows}</p>""")
    js.Dynamic.global.jQuery("#playground").append(s"""<p>${List("Hello", "by", "Dynamic").shows}</p>""")
  }
}
