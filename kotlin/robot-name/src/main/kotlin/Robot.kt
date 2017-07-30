import java.security.SecureRandom

/**
 * Created by yannickgrenzinger on 17/08/2016.
 */
class Robot {
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray()
    val random = SecureRandom()
    var name: String = generateRandomName()

    private fun generateRandomName() : String {
        val builder = StringBuilder()
        builder.append(randomChar())
        builder.append(randomChar())
        builder.append(randomInt())
        builder.append(randomInt())
        builder.append(randomInt())
        return  builder.toString()
    }

    private fun randomChar() : Char {
        return alphabet.get(random.nextInt(alphabet.size))
    }

    private fun randomInt() : Int {
        return random.nextInt(10)
    }

    fun reset() {
        name = generateRandomName()
    }
}