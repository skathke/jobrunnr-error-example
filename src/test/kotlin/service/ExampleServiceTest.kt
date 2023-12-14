package service

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.jobrunr.configuration.JobRunr
import org.jobrunr.jobs.mappers.JobMapper
import org.jobrunr.storage.InMemoryStorageProvider
import org.jobrunr.utils.mapper.jackson.JacksonJsonMapper
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleServiceTest {
    @Inject lateinit var exampleService: ExampleService

    @Test
    fun testScheduler() {
        println("Initializing JobRunr")
        val storageProvider = InMemoryStorageProvider()
        storageProvider.setJobMapper(JobMapper(JacksonJsonMapper()))
        JobRunr.configure().useStorageProvider(InMemoryStorageProvider()).useBackgroundJobServer().initialize()
        println("JobRunr initialized")
        exampleService.testScheduler()
    }
}