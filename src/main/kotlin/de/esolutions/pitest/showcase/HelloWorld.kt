package de.esolutions.pitest.showcase

class HelloWorld {
    fun helloWorld() {
        if(myMap.containsKey("foo") && myHashMap.containsKey("foo")) {
            println("Hello World")
        }
    }

    companion object {
        // no problem when map is created with constructor
        val myHashMap = HashMap<String, String>().apply { put("foo", "bar") }

        // PITEST: replaced return value with Collections.emptyMap for de/esolutions/pitest/showcase/HelloWorld$Companion::getMyMap → NO_COVERAGE
        val myMap = mapOf("foo" to "bar")
    }
}