/**
 * Created by yannickgrenzinger on 17/08/2016.
 */
class PhoneNumber(userEnteredNumber: String) {
    companion object {
        @JvmField
        val badNumber = "0000000000"
    }

    val number = clean(userEnteredNumber)
    val areaCode = number.substring(0, 3)
    val formattedNumber = format()

    private fun clean(userInput: String): String {
        val cleanedNumber = userInput.replace(Regex("[\\(\\)\\s\\-\\.]"), "")
        return when (cleanedNumber.length) {
            10 -> cleanedNumber
            11 -> if (cleanedNumber.startsWith("1")) {
                cleanedNumber.substring(1)
            } else {
                badNumber
            }
            else -> badNumber
        }
    }

    private fun format(): String {
        return "(" + areaCode + ") " + number.substring(3, 6) + "-" + number.substring(6, 10)
    }

    override fun toString(): String {
        return formattedNumber
    }


}