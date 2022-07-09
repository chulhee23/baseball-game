package adapter

import domain.ball.Ball
import domain.player.Player
import domain.ports.inbound.AskBallResult
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class AskBallResultServiceTest : FunSpec({

    val sut = AskBallResultService()


    context("공 질문 기능 명세") {
        val computerBall = Ball(1,2,3)

        val computer = Player(
            computerBall
        ).also { println(it) }


        val ball_1 = Ball(6,3,5)
        val strike_1 = Ball(1,4,5)
        val ball_1_strike_1 = Ball(1,3,5)
        val ball_3 = Ball(3,1,2)
        val strike_2 = Ball(1,2,4)

        val answerBall = Ball(1,2,3)

        test("1볼 ") {
            sut.execute(computer, ball_1) shouldBe AskBallResult(1, 0)
        }
        test("1 스트라이크") {
            sut.execute(computer, strike_1) shouldBe AskBallResult(0, 1)
        }
        test("2 스트라이크") {
            sut.execute(computer, strike_2) shouldBe AskBallResult(0, 2)
        }
        test("1볼 1스트라이크") {
            sut.execute(computer, ball_1_strike_1) shouldBe AskBallResult(1, 1)
        }
        test("3볼") {
            sut.execute(computer, ball_3) shouldBe AskBallResult(3, 0)
        }
        test("정답 - 3 strike") {
            sut.execute(computer, answerBall) shouldBe AskBallResult(0, 3)
        }




    }
})
