package de.esolutions.pitest.showcase

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HelloWorldTest {
    @Test
    fun `should print 'Hello World'`() {
        val outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
        HelloWorld().helloWorld()
        // this does not kill the mutation but fails if myMap is empty
        // the reason is that myMap is accessed directly and not through the
        // generated public accessor
        assertEquals("Hello World\n", outputStreamCaptor.toString())

        // this assert kills the mutation as is uses the accessor
        assertTrue(HelloWorld.myMap.containsKey("foo"))
    }
}