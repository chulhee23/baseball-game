package adapter

import domain.ball.Ball
import domain.player.Player
import domain.ports.inbound.AskBallResult
import domain.ports.inbound.AskBallResultToPlayerUseCase

class AskBallResultService : AskBallResultToPlayerUseCase {
    override fun execute(player: Player, askBall: Ball): AskBallResult {
        val (strikeCount, ballCount) = compareBalls(player.ball, askBall)
        return AskBallResult(ballCount = ballCount, strikeCount = strikeCount)
    }

    private fun compareBalls(ball: Ball, askBall: Ball): Pair<Int, Int> {
        var strikeCount = 0
        var ballCount = 0
        if (ball.first == askBall.first) strikeCount += 1
        if (ball.second == askBall.second) strikeCount += 1
        if (ball.third == askBall.third) strikeCount += 1

        if (ball.first == askBall.second || ball.first == askBall.third) ballCount += 1
        if (ball.second == askBall.first || ball.second == askBall.third) ballCount += 1
        if (ball.third == askBall.first || ball.third == askBall.second) ballCount += 1

        return Pair(strikeCount, ballCount)
    }


}
