package tachiyomi.domain.items.service

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(ExecutionMode.CONCURRENT)
class MissingItemsTest {

    @Test
    fun `returns 0 when empty list`() {
        emptyList<Float>().missingItemsCount() shouldBe 0
    }

    @Test
    fun `returns 0 when all unknown chapter numbers`() {
        listOf(-1f, -1f, -1f).missingItemsCount() shouldBe 0
    }

    @Test
    fun `handles repeated base chapter numbers`() {
        listOf(1f, 1.0f, 1.1f, 1.5f, 1.6f, 1.99f).missingItemsCount() shouldBe 0
    }

    @Test
    fun `returns number of missing chapters`() {
        listOf(-1f, 1f, 2f, 2.2f, 4f, 6f, 10f, 11f).missingItemsCount() shouldBe 5
    }
}