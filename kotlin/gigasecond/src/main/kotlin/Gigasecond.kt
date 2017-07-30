import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by yannickgrenzinger on 12/08/2016.
 */
class Gigasecond(birthDate: LocalDateTime) {
    val gigaseconds = BigInteger.TEN.pow(9).toLong()
    val date: LocalDateTime = birthDate.plusSeconds(gigaseconds)

    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())
}