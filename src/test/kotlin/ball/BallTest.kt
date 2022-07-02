package ball

import domain.ball.Ball
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName


@DisplayName("볼 명세")
internal class BallTest : FunSpec({

    context("볼 생성 규칙.") {

        test("3개의 1 ~ 9 이내의 숫자로 구성되어 있다.") {
            val ball = Ball.createRandom()
            
            ball.first shouldBeInRange  1..9
            ball.second shouldBeInRange  1..9
            ball.third shouldBeInRange  1..9
        }

        test("같은 숫자를 가질 수 없다.") {
            repeat(10) {
                val ball = Ball.createRandom()
                ball.first shouldNotBe ball.second
                ball.second shouldNotBe ball.third
            }
        }

    }
})
