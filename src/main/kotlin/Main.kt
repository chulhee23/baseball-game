import adapter.InputViewCommandLine

fun main(args: Array<String>) {
    println("사용자 공을 입력합니다.")
    val userBall = InputViewCommandLine.getBallPlayer()
    println("컴퓨터 공을 입력합니다.")
    val computerBall = InputViewCommandLine.getBallPlayer()

    Game.play(userBall, computerBall)
}
