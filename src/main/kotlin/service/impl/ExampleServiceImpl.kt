package service.impl

import jakarta.enterprise.context.ApplicationScoped
import org.jobrunr.scheduling.BackgroundJob
import service.ExampleService
import java.time.Instant

@ApplicationScoped
class ExampleServiceImpl: ExampleService {

    override fun testScheduler(){
        BackgroundJob.schedule(Instant.now().plusSeconds(60)) { println("Test") }
    }
}