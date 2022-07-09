package adapter

import domain.ball.Ball
import domain.player.Player

class InputViewCommandLine {
    companion object {
        fun getBallPlayer(): Player {
            println("공을 입력해주세요.")
            val numbers = getNumbers()
            return Player(
                Ball(numbers[0], numbers[1], numbers[2])
            )
        }

        fun getAskBall(): Ball {
            val numbers = getNumbers()
            return Ball(numbers[0], numbers[1], numbers[2])
        }

        private fun getNumbers(): List<Int> {
            val ballNumbers = readLine() ?: throw IllegalArgumentException()
            return ballNumbers.map { Character.getNumericValue(it) }
        }

    }

}
