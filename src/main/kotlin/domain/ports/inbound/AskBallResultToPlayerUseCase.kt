package domain.ports.inbound

import domain.ball.Ball
import domain.player.Player

interface AskBallResultToPlayerUseCase {

    fun execute(player: Player, askBall: Ball): AskBallResult
}


data class AskBallResult(
    val ballCount: Int,
    val strikeCount: Int
) {
    companion object {
        const val MAX_COUNT = 3
    }

    fun isSuccess(): Boolean {
        return this.strikeCount == MAX_COUNT
    }

    fun toAnswer(): String {
        return when {
            strikeCount == MAX_COUNT -> "정답입니다!"
            ballCount != 0 && strikeCount != 0 -> "${ballCount}볼${strikeCount}스트라이크"
            ballCount != 0 -> "${ballCount}볼"
            strikeCount != 0 -> "${strikeCount}스트라이크"
            else -> "낫싱"
        }
    }
}
