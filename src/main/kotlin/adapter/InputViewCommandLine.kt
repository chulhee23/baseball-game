package adapter

import domain.ball.Ball
import domain.player.Player

class InputViewCommandLine {
    companion object {
        fun getBallPlayer(): Player {
            println("공을 입력해주세요.")
            val ballNumbers = readLine() ?: throw IllegalArgumentException()
            val numbers = ballNumbers.map { it.code }
            return Player(
                Ball(numbers[0], numbers[1], numbers[2])
            )
        }
    }

}
