enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
){
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) = 
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "netural"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval1(e: Expr): Int {
    if (e is Num){
        return e.value
    }
    if (e is Sum){
        return eval1(e.left) + eval1(e.right)
    }
    throw IllegalArgumentException("unkown expression")
}

fun eval2(e: Expr): Int =  
    if (e is Num){
        e.value
    }
    else if (e is Sum){
        eval2(e.left) + eval2(e.right)
    }else{
        throw IllegalArgumentException("unkown expression")
    }

fun eval3(e: Expr): Int =  
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = eval3(e.left)
            val right = eval3(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("unkown expression")
    }

println(getMnemonic(Color.BLUE))
println(getWarmth(Color.RED))
println(Color.BLUE.rgb())
println(mix(Color.RED, Color.YELLOW))
println(mix(Color.YELLOW, Color.RED))
println(eval1(Sum(Sum(Num(1), Num(2)), Num(4))))
println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
