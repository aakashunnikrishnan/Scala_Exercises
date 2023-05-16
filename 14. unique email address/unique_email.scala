def numUniqueEmails(emails: Array[String]): Int = {
  val uniqueEmails = scala.collection.mutable.Set[String]()

  for (email <- emails) {
    val parts = email.split("@")
    val localName = parts(0)
    val domainName = parts(1)

    val sanitizedLocalName = sanitizeLocalName(localName)

    val fullEmail = sanitizedLocalName + "@" + domainName
    uniqueEmails.add(fullEmail)
  }

  uniqueEmails.size
}

def sanitizeLocalName(localName: String): String = {
  val sanitized = new StringBuilder()

  var i = 0
  while (i < localName.length && localName(i) != '+' && localName(i) != '@') {
    if (localName(i) != '.') {
      sanitized.append(localName(i))
    }
    i += 1
  }

  sanitized.toString()
}
