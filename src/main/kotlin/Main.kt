import adapter.AskBallResultService
import adapter.InputViewCommandLine
import domain.Game

fun main(args: Array<String>) {
    println("사용자 공을 입력합니다.")
    val userPlayer = InputViewCommandLine.getBallPlayer()
    println("컴퓨터 공을 입력합니다.")
    val computerPlayer = InputViewCommandLine.getBallPlayer()
    val game = Game(
        askBallResultToPlayerUseCase = AskBallResultService(),
        player =  userPlayer,
        computer = computerPlayer
    )
    game.play()

}
