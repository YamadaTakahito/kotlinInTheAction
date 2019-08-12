fun main(args: Array<String>) {
    // val name = if (args.size > 0) args[0] else "kotlin"
    println("Hello, ${if (args.size > 0) args[0] else "kotlin"}")
}

main(arrayOf("w"))
