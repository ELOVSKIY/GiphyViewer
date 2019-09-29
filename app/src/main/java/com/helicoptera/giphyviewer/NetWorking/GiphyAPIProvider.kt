package NetWorking

import com.helicoptera.mainview.NetWorking.Data.GiphyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "gq7dCTIoc8G8MLvtRzYpmVGqZpCCmFBL"

val atings = listOf("")

val contentRating = listOf("G", "PG", "PG-13", "R")
interface GiphyAPIProvider {

    @GET("search")
    fun getGifImages(
            @Query("api_key") apiKey: String = API_KEY,
            @Query("q") query: String = "",
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int = 0,
            @Query("rating") rating: String = "g",
            @Query("lang") lang: String = "en"
    ): Call<GiphyResponse>

}