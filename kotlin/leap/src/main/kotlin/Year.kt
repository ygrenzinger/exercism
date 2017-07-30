/**
 * Created by yannickgrenzinger on 17/08/2016.
 */
class Year(year: Int) {
    val  isLeap: Boolean = year%4 == 0 && !(year % 400 != 0 && year % 100 == 0)

}