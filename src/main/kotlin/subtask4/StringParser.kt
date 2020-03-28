package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {

        var substringsList = mutableListOf<String>();

        for (i in inputString.indices) {
            when (inputString[i]) {
                '<' -> substringsList.add(
                    inputString.substring(
                        i + 1,
                        getPosition(inputString, i, '<', '>')
                    )
                )
                '[' -> substringsList.add(
                    inputString.substring(
                        i + 1,
                        getPosition(inputString, i, '[', ']')
                    )
                )
                '(' -> substringsList.add(
                    inputString.substring(
                        i + 1,
                        getPosition(inputString, i, '(', ')')
                    )
                )
            }
        }

        return substringsList.toTypedArray();
    }

    private fun getPosition(
        inputString: String,
        startPosition: Int,
        openBracket: Char,
        closeBracket: Char
    ): Int {
        var position = -1;
        var bracketCounts = 0;
        for (i in startPosition until inputString.length) {
            if (inputString[i] == openBracket) {
                bracketCounts++;
            }
            if (inputString[i] == closeBracket && bracketCounts != 0) {
                bracketCounts--;
            }
            if (inputString[i] == closeBracket && bracketCounts == 0) {
                position = i;
                break;
            }
        }

        return position;
    }
}
