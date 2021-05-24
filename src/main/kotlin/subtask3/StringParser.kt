package subtask3

import java.util.*

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var str = arrayListOf<String>()
        inputString.asSequence().forEachIndexed { i, char ->
            when (char) {
                '<' -> str.add(inputString.substring(i + 1, inputString.indexOfFirst { c -> c == '>' }))
                '[' -> str.add(inputString.substring(i + 1, inputString.indexOfFirst { c -> c == ']' }))
                '(' -> str.add(inputString.substring(i + 1, inputString.indexOfFirst { c -> c == ')' }))
            }
        }
        return arrayOf(str.)
    }
}
