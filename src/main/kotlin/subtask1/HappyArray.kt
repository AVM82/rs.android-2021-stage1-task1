package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        var array = sadArray.copyOf()
        while (!isHappyArray(array)) {
            array = array.indices
                .filter { i -> !isBadElement(array, i) }
                .map { i: Int -> array[i] }
                .toIntArray()
        }
        return array
    }

    fun isHappyArray(array: IntArray): Boolean {
        if (array.size > 2) {
            for (i in 1..array.size - 2) {
                if (isBadElement(array, i)) {
                    return false
                }
            }
        }
        return true
    }

    private fun isBadElement(array: IntArray, index: Int): Boolean {
        return if (index in 1..array.size - 2) {
            array[index - 1] + array[index + 1] < array[index]
        } else {
            false
        }
    }
}
