package domain

import adapter.InputViewCommandLine
import domain.ball.Ball
import domain.player.Player
import domain.ports.inbound.AskBallResultToPlayerUseCase

class Game(
    private val askBallResultToPlayerUseCase: AskBallResultToPlayerUseCase,
    private val player: Player,
    private val computer: Player
) {
    init {
        println("players: $player, computer: $computer")
        println("게임 세팅이 되었습니다.")
    }

    fun play(round: Int = 1) {
        println("=======round: $round =======")
        val turn = round % 2

        val result = if (turn == 0) {
            println("player 님의 차례")

            playMyTurn(InputViewCommandLine.getAskBall())
        } else {
            println("컴퓨터 차례입니다.")
            computerTurn()
        }

        if (result) {
            println("GAME END")
            return
        }

        play(round + 1)
    }

    private fun playMyTurn(askBall: Ball) : Boolean {

        val result = askBallResultToPlayerUseCase.execute(computer, askBall)
        return result.isSuccess()
    }

    private fun computerTurn() : Boolean {
        val result = askBallResultToPlayerUseCase.execute(player, Ball.createRandom())

        return result.isSuccess()
    }

}
