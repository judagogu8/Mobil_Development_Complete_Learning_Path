package com.example.fundamentals

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // However, we have the "const" keyword that can be used to declare a compile-time constant.
    // But, it can only be used at the top level or in an object declaration.
    // Using companion object, we can declare a constant inside a class.

    // "companion object" is a singleton object that is tied to the class in which it is declared.
    companion object {

        // "const" keyword is used to declare a compile-time constant, which means that the value of the constant is known at compile time.
        // This makes the constant more efficient than a regular variable because the value of the constant is replaced with the actual value at compile time.
        // But, we can't do pre-processing with the value of the constant like we can do with a regular variable.
        const val PI = 3.14159
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // The first steps using Kotlin, we are going to start with variables:

        // The "var" keyword is used to declare a mutable variable, which means that the value of the variable can be changed.
        var age = 30
        System.out.println(age)
        println(age)

        // Changing the value of the variable
        age = 31
        println(age)

        // The "val" keyword is used to declare a read-only variable, which means that the value of the variable cannot be changed.
        val name = "John"
        println(name)

        // The following line will cause a compilation error because we are trying to change the value of a read-only variable.
        // name = "Jane"

        // Now, with the data types:
        // Kotlin is a statically typed language, which means that the type of a variable is known at compile time.
        // When a variable is declared, the type of the variable is specified after the variable name.
        // The following are some of the basic data types in Kotlin:

        // Integer types
        val byte: Byte = 1

        val short: Short = 1

        val int: Int = 1

        val long: Long = 1

        // Floating-point types
        val float: Float = 1.0f

        val double: Double = 1.0

        // Characters
        val char: Char = 'a'

        // Booleans
        val boolean: Boolean = true

        // Strings
        val string: String = "Hello, World!"

        // Arrays (fixed-size collections of elements of the same type):
        val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5)

        // Ranges (a sequence of values with a start and an end):
        val intRange: IntRange = 1..10 // The notation 1..10 is equivalent to IntRange(1, 10)
        val charRange: CharRange = 'a'..'z' // The notation 'a'..'z' is equivalent to CharRange('a', 'z')
        val longRange: LongRange = 1L..10L // The notation 1L..10L is equivalent to LongRange(1L, 10L)

        // Lists (ordered collections of elements of the same type):
        val intList: List<Int> = listOf(1, 2, 3, 4, 5)

        // Maps (key-value pairs):
        val intToStringMap: Map<Int, String> = mapOf(1 to "One", 2 to "Two", 3 to "Three")

        // Sets (unordered collections of unique elements):
        val intSet: Set<Int> = setOf(1, 2, 3, 4, 5)

        // What is the difference between a list and a set?
        // A list is an ordered collection of elements, which means that the elements are stored in a specific order.
        // A set is an unordered collection of unique elements, which means that the elements are not stored in a specific order, and duplicate elements are not allowed.

        // Important:
        //  -> As well as kotlin is a statically typed language, once a variable is declared with a specific type, it cannot be changed to another type.
        //  -> Although Kotlin has type inference, it is always a good practice to specify the type of a variable explicitly.

        // Now, let's see we can do conversions between data types:
        val intNumber = 1
        val longNumber = intNumber.toLong()
        val floatNumber = intNumber.toFloat()
        val doubleNumber = intNumber.toDouble()
        val shortNumber = intNumber.toShort()
        val byteNumber = intNumber.toByte()
        val charNumber = intNumber.toChar()
        val stringNumber = intNumber.toString()
        val booleanNumber = intNumber > 0
        val intNumber2 = longNumber.toInt()


        // Concatenations methods:
        val firstName = "John"
        val lastName = "Doe"

        // Using the "+" operator
        println(firstName + " " + lastName)

        // Using the "plus" method
        println(firstName.plus(" ").plus(lastName))

        // Using string templates
        println("$firstName $lastName")
        println("The first name is ${firstName.toUpperCase()} and the last name is ${lastName.toLowerCase()}")
        // The difference between the two is that string templates can contain expressions, while string interpolation cannot.

        // Using the "format" method
        println("%s %s".format(firstName, lastName))

        // Using the "StringBuilder" class
        val fullName = StringBuilder()
        fullName.append(firstName)
        fullName.append(" ")
        fullName.append(lastName)
        println(fullName.toString())

        // Using the "buildString" function
        val fullName2 = buildString {
            append(firstName)
            append(" ")
            append(lastName)
        }
        println(fullName2)

        // Using the "StringBuffer" class
        val fullName3 = StringBuffer()
        fullName3.append(firstName)
        fullName3.append(" ")
        fullName3.append(lastName)
        println(fullName3.toString())

        // Now, one of the most important things in programming is the statements:
        // "if" statement:
        val number = 10
        if (number > 0) {
            println("The number is positive😀")
        } else if (number < 0) {
            println("The number is negative🥲")
        } else {
            println("The number is zero🫥")
        }
        val date = "01/01/2021"

        // In this case, we are using the "subSequence" method to get the month part of the date.
        // The "subSequence" method returns a subsequence of the original sequence.
        // The "subSequence" method takes two arguments: the start index and the end index.
        // The start index is inclusive, and the end index is exclusive.
        // The "toString" method is used to convert the subsequence to a string.
        // The "toInt" method is used to convert the string to an integer.
        val month = date.subSequence(3, 5).toString().toInt()

        // "when" statement (similar to the "switch" statement in other programming languages, but more powerful because it can be used with any type of data):
        when (month) {
            1, 2, 3 -> println("\n It's the winter season! 🥶")
            4, 5, 6 -> println("\n It's the spring season! 🥳")
            7, 8, 9 -> println("\n It's the summer season! 🤯")
            10, 11, 12 -> println("\n It's the autumn season! 😷")
            else -> println("\n Invalid month! ?? 🤬")
        }

        // The "do while" statement:
        var i = 0
        do {
            println("The value of i is $i 🥵")
            i++
        } while (i < 5)

        // The "while" statement:
        var j = 0
        while (j < 5) {
            println("The value of j is $j ??")
            j++
        }

        // The "for" statement:
        for (k in 0 until 5) {
            println("The value of k is $k ??")
        }

        // The "for" statement with a step:
        for (l in 0 until 5 step 2) {
            println("The value of l is $l ??")
        }

        // The "for" statement with a downTo range:
        for (m in 5 downTo 0) {
            println("The value of m is $m ??")
        }

        // The "for" statement with a downTo range and a step:
        for (n in 5 downTo 0 step 2) {
            println("The value of n is $n ??")
        }

        // The "for" statement with a list:
        val numbers = listOf(1, 2, 3, 4, 5)
        for (number in numbers) {
            println("The value of number is $number ??")
        }

        // The "for" statement with a map:
        val numberToNameMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
        for ((number, name) in numberToNameMap) {
            println("The value of number is $number and the value of name is $name ??")
        }

        // The "for" statement with a range:
        for (o in 1..5) {
            println("The value of o is $o ??")
        }

        // The "for" statement with a range and a step:
        for (p in 1..5 step 2) {
            println("The value of p is $p ??")
        }

        // The "for" statement with a range and a downTo range:
        for (q in 5 downTo 1) {
            println("The value of q is $q ??")
        }

        // The "for" statement with a range and a downTo range and a step:
        for (r in 5 downTo 1 step 2) {
            println("The value of r is $r ??")
        }

        // The stop statements:

        for (s in 1..5) {
            if (s == 3) {

                // The "break" statement is used to exit a loop.
                println("Whoops! The value of s is $s. I'm breaking out of the loop! 🫡")
                break
            }
            else if (s == 2) {

                // The "continue" statement is used to skip the current iteration of a loop.
                println("Whoops! The value of s is $s. I'm skipping this iteration! 🤔")
                continue
            }
            println("The value of s is $s ??")
        }

        // Calling functions:
        greet()
        greet("John")
        println(add(1, 2))
        println(getPi())
        greet("John", "Hi")
        greet("John", "Jane", "Jack")
        greet("John") { name -> "Hello, $name! ??" }
    }

    // Now, let's see how we can create functions in Kotlin:
    // The "fun" keyword is used to declare a function.
    // The function name is followed by the parameter list in parentheses.
    // The return type of the function is specified after the parameter list.
    // The body of the function is enclosed in curly braces.

    // Function with no parameters and no return type:
    fun greet() {
        println("Hello, World! ??")
    }

    // Function with parameters and no return type:
    fun greet(name: String) {
        println("Hello, $name! ??")
    }

    // Function with parameters and a return type:
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // Function with no parameters and a return type:
    fun getPi(): Double {
        return PI
    }

    // Function with a default parameter:
    fun greet(name: String, message: String = "Hello") {
        println("$message, $name! ??")
    }

    // Function with a variable number of arguments (this means that the function can take any number of arguments, but they must be of the same type):
    fun greet(vararg names: String) {
        for (name in names) {
            println("Hello, $name! ??")
        }
    }

    // Function with a lambda expression:
    fun greet(name: String, message: (String) -> String) {
        println(message(name))
    }

    // Function with a lambda expression and a return type:
    fun add(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }
}