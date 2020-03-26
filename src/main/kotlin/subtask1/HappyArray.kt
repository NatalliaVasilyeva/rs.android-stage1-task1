package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        var happyArray = sadArray.toMutableList();

        if (happyArray.isNotEmpty()) {
            for (i in happyArray.size - 2 downTo 1) {
                if (happyArray[i] > happyArray[i - 1] + happyArray[i + 1]) {
                    happyArray.removeAt(i);
                }
            }
        }
        return happyArray.toIntArray()
    }
}