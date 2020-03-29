package subtask5

import java.lang.StringBuilder

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var result = StringBuilder(digitString)
        val stringLength = n;
        var numberOfRepeats = k;
        var numberOfNeedChanges = takeNumberOfChangesInString(digitString, stringLength)
        var differences = numberOfRepeats - numberOfNeedChanges

        if (differences < 0) {
            return "-1"
        }

        for (digits in 0 until stringLength / 2) {
            var startElement = digitString[digits]
            var endElement = digitString[stringLength - 1 - digits]
            if (startElement!= endElement && differences>=0) {
                if (differences > 0) {
                    result[digits] = '9'
                    result[stringLength - digits - 1] = '9'
                    differences--
                } else {
                    result[digits] = maxOf(startElement, endElement);
                    result[stringLength - digits - 1] = maxOf(startElement, endElement);
                }
            }
        }
    return result.toString()
}


private fun takeNumberOfChangesInString(digitString: String, stringLength: Int): Int {
    var numberOfChanges = 0
    for (i in 0 until stringLength / 2) {
        if (digitString[i] != digitString[digitString.length - i - 1]) {
            numberOfChanges++
        }
    }
    return numberOfChanges;
}

}
