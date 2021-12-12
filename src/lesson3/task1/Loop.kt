@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import java.lang.StrictMath.min
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var num = 0
    var x = abs(n)
    do {
        x /= 10
        num += 1
    } while (x > 0)
    return num
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var s1 = 1
    var s2 = 1
    var s = 0
    if (n in 1..2) {
        s = 1
    }
    for (i in 3..n) {
        s = s1 + s2
        s1 = s2
        s2 = s
    }
    return s
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i = 1
    do {
        i += 1
    } while (n % i != 0)
    return i
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = (n / minDivisor(n))


/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var counter = 0
    var y = x
    return if (x == 1) 0
    else {
        do {
            if (y % 2 == 0) {
                y /= 2
            } else {
                y = 3 * y + 1
            }
            counter += 1
        } while (y != 1)
        counter
    }
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun gcd(n: Int, m: Int): Int {
    var i = minOf(m, n)
    return if ((m % i == 0) && (n % i == 0)) i
    else {
        do {
            i -= 1
        } while ((n % i != 0) || (m % i != 0))
        i
    }
}

fun lcm(m: Int, n: Int): Int {
    val div = gcd(m, n)
    return abs(m * n) / div
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val indicator = true
    val minMN = min(m, n)
    for (i in 2..minMN) {
        if ((m % i == 0) && (n % i == 0)) return false
    }
    return indicator

}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var k = digitNumber(n)
    var y = 0
    var digit: Int
    var i = n
    do {
        k -= 1
        digit = i % 10
        y += digit * 10.0.pow(k.toDouble()).toInt()
        i /= 10
    } while (i > 0)
    return y

}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    val k = digitNumber(n)
    return if (k == 1)
        true
    else if (k % 2 != 0) {
        val rightHalf = revert((n % ((10.0).pow(k / 2))).toInt())
        var leftHalf = ((n / ((10.0).pow((k / 2).toDouble() + 1.0)))).toInt()
        if (leftHalf % 10 == 0) do {
            leftHalf /= 10
        } while (leftHalf % 10 == 0)
        leftHalf == rightHalf
    } else {
        val rightHalf = revert((n % ((10.0).pow((k / 2).toDouble()))).toInt())
        var leftHalf = (n / ((10.0).pow((k / 2).toDouble()))).toInt()
        if (leftHalf % 10 == 0) do {
            if (leftHalf % 10 == 0) {
                leftHalf /= 10

            }
        } while (leftHalf % 10 == 0)

        rightHalf == leftHalf
    }
}


/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var flag = false
    var m = abs(n)
    if (m < 10) return false
    val x = m % 10
    do {
        m /= 10
        if (x != m % 10) {
            flag = true; break
        }
    } while (m > 9)
    return flag
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 0
    var sqrNumber: Int
    var i = 1
    do {
        sqrNumber = i * i
        k += digitNumber(sqrNumber)
        i += 1
    } while (k < n)
    return fibN(k, n, sqrNumber)
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var k = 2
    var i = 3
    var fibNumber: Int
    if ((n == 1) || (n == 2)) return 1
    do {
        fibNumber = fib(i)
        k += digitNumber(fibNumber)
        i += 1
    } while (k < n)
    return fibN(k, n, fibNumber)
}

private fun fibN(k: Int, n: Int, fibNumber: Int): Int {
    var fibNumber1 = fibNumber
    fibNumber1 /= ((10.0).pow((k - n).toDouble())).toInt()
    return fibNumber1 % 10

}

