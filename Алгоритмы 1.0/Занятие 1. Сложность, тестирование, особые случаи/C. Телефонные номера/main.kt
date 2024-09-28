fun main() {
    var newNumber = requireNotNull(readLine())
    val contacts: MutableList<String> = mutableListOf()
    contacts.add(requireNotNull(readLine()))
    contacts.add(requireNotNull(readLine()))
    contacts.add(requireNotNull(readLine()))

    newNumber = newNumber.replace(Regex("[^0-9]"), "")
    contacts[0] = contacts[0].replace(Regex("[^0-9]"), "")
    contacts[1] = contacts[1].replace(Regex("[^0-9]"), "")
    contacts[2] = contacts[2].replace(Regex("[^0-9]"), "")

    newNumber = if (newNumber.length >= 10) {
        newNumber.takeLast(10)
    } else { 
        "495" + newNumber.takeLast(7)   
    }

    for (i in contacts.indices) {
        contacts[i] = if (contacts[i].length >= 10) {
            contacts[i].takeLast(10)
        } else {
            "495" + contacts[i].takeLast(7)
        }
    }

    /*
    println("")
    println(newNumber)
    println(contacts[0])
    println(contacts[1])
    println(contacts[2])
    println("")
    */

    for (contact in contacts) {
        if (newNumber == contact) println("YES")
        else println("NO")
    }
}