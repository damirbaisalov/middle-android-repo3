package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository
import kotlin.time.Duration.Companion.seconds

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(DELETE_DELAY)
        repository.deleteTask(taskId)
    }

    companion object {
        private val DELETE_DELAY = 10.seconds
    }
}
