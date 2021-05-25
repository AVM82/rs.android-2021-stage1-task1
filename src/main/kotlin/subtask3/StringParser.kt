package subtask3

class StringParser {

    private var resultArray = arrayListOf<String>()
    private val angleBrackets = Brackets(head = '<', tail = '>')
    private val squareBrackets = Brackets(head = '[', tail = ']')
    private val roundBrackets = Brackets(head = '(', tail = ')')

    private fun findTail(substring: String, brackets: Brackets): Int {
        substring.forEachIndexed { index, char ->
            when (char) {
                brackets.tail -> if (index != brackets.tailIndex) return index
                brackets.head -> {
                    brackets.tailIndex =
                        index + 1 + findTail(
                            substring.substring(index + 1, substring.length),
                            brackets
                        )
                    resultArray.add(substring.substring(index + 1, brackets.tailIndex))
                }
            }
        }
        return brackets.tailIndex
    }

    fun getResult(inputString: String): Array<String> {

        inputString.forEachIndexed { index, char ->
            when (char) {
                angleBrackets.head -> putSubstringToArray(index, inputString, angleBrackets)
                squareBrackets.head -> putSubstringToArray(index, inputString, squareBrackets)
                roundBrackets.head -> putSubstringToArray(index, inputString, roundBrackets)
            }
        }
        return resultArray.toTypedArray()
    }

    private fun putSubstringToArray(index: Int, inputString: String, brackets: Brackets) {
        if (index > brackets.tailIndex) {
            val substring = inputString.substring(index + 1, inputString.length)
            resultArray.add(
                inputString.substring(
                    index + 1,
                    index + 1 + findTail(substring, brackets)
                )
            )
            brackets.tailIndex += index
        }
    }
}
