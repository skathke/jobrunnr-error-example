package resource

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response
import org.jobrunr.configuration.JobRunr
import org.jobrunr.storage.InMemoryStorageProvider
import service.ExampleService

@Path("api/example")
class ExampleResource (
    private val exampleService: ExampleService
){

    @POST
    @Path("/test")
    suspend fun testScheduler() : Response {
        //Note: This is just for the minimum example to work.
        JobRunr.configure().useStorageProvider(InMemoryStorageProvider()).useBackgroundJobServer().initialize()
        exampleService.testScheduler()
        return Response.ok().build()
    }
}