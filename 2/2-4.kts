fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Bazz "
    else -> "$i "
}

// for (i in 100 downTo 1 step 2){
//     print(fizzBuzz(i))
// }

val binaryReps: MutableMap<Char, String> = mutableMapOf()

for (c in 'A'..'F') {
    val binary = Integer.toBinaryString(c.toInt())
    binaryReps[c] = binary
}

for ((letter, binary) in binaryReps) {
    println("$letter = $binary")
}

val list = arrayListOf("10", "11", "1001")
for ((idx, el) in list.withIndex()){
    println("$idx: $el")
}
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit1"
    in 'a'..'z', in 'A'..'Z' -> "it's a letter!"
    else -> "I don't know.."
}

println(recognize("8"))

