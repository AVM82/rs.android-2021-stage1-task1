package subtask2

class BillCounter {

    companion object {
        private const val FAIRLY_SPLIT = "bon appetit"
    }

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        return when (val annaShareBill =
            b - bill.asSequence().filterIndexed { index, _ -> index != k }.sum() / 2) {
            0 -> FAIRLY_SPLIT
            else -> annaShareBill.toString()
        }
    }
}
