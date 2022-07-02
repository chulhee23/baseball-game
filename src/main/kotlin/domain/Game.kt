package domain

import adapter.AskBallResultService
import domain.player.Player
import domain.ports.inbound.AskBallResultToPlayerUseCase

class Game(
    private val askBallResultService: AskBallResultService
) {

        fun play(player: Player, computer: Player) {
            askBallResultService.execute(player, )
        }
}
