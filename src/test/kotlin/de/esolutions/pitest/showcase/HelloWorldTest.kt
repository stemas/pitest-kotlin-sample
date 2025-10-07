package de.esolutions.pitest.showcase

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class HelloWorldTest {
    @Test
    fun `should print 'Hello World'`() {
        val outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
        HelloWorld().helloWorld()
        assertEquals("Hello World\n", outputStreamCaptor.toString())
    }
}