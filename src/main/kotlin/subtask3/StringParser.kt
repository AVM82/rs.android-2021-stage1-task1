package subtask3

class StringParser {
    private var str = arrayListOf<String>()

    class Brackets(val head: Char, val tail: Char, var tailIndex: Int = 0)

    private val angleBrackets = Brackets(head = '<', tail = '>')
    private val squareBrackets = Brackets(head = '[', tail = ']')
    private val roundBrackets = Brackets(head = '(', tail = ')')


    private fun findTail(substring: String, brackets: Brackets): Int {
        substring.forEachIndexed { i, c ->
            when (c) {
                brackets.tail -> if (i != brackets.tailIndex) return i
                brackets.head -> {
                    brackets.tailIndex =
                        i + 1 + findTail(substring.substring(i + 1, substring.length), brackets)
                    str.add(substring.substring(i + 1, brackets.tailIndex))
                }
            }
        }
        return brackets.tailIndex
    }

    fun getResult(inputString: String): Array<String> {

        inputString.forEachIndexed { i, char ->
            when (char) {
                angleBrackets.head -> {
                    if (i > angleBrackets.tailIndex) {
                        val substring = inputString.substring(i + 1, inputString.length)
                        str.add(
                            inputString.substring(
                                i + 1,
                                i + 1 + findTail(substring, angleBrackets)
                            )
                        )
                        angleBrackets.tailIndex += i
                    }
                }
                squareBrackets.head -> {
                    if (i > squareBrackets.tailIndex) {
                        val substring = inputString.substring(i + 1, inputString.length)
                        str.add(
                            inputString.substring(
                                i + 1,
                                i + 1 + findTail(substring, squareBrackets)
                            )
                        )
                        squareBrackets.tailIndex += i
                    }
                }
                roundBrackets.head -> {
                    if (i > roundBrackets.tailIndex) {
                        val substring = inputString.substring(i + 1, inputString.length)
                        str.add(
                            inputString.substring(
                                i + 1,
                                i + 1 + findTail(substring, roundBrackets)
                            )
                        )
                        roundBrackets.tailIndex += i
                    }
                }
            }
        }
        return str.toTypedArray()
    }
}
