package domain.ball

data class Ball(
    val first: Int,
    val second: Int,
    val third: Int,
) {

    companion object {
        private const val MAX_NUM = 10
        fun createRandom() : Ball {
            val candidates = mutableListOf(1,2,3,4,5,6,7,8,9)

            return Ball(
                candidates.randomPop(),
                candidates.randomPop(),
                candidates.randomPop()
            )
        }
    }

    override fun toString(): String {
        return "Ball(first=$first, second=$second, third=$third)"
    }
}

private fun <T> MutableList<T>.randomPop() = this.random().also { this.remove(it) }
