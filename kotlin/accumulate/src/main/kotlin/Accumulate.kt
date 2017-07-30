/**
 * Created by yannickgrenzinger on 12/08/2016.
 */
object Accumulate {
    fun <R, S> accumulate(inputs: List<R>, f: (R) -> S): List<S> {
        return inputs.map(f)
    }
}