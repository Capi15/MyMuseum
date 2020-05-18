import com.example.mymuseum.retrofit.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {

    @POST("login")
    fun login(@Body user: User?): Call<User?>?

    @POST("register")
    fun register(@Body user: User?): Call<User?>?

    @POST("logout")
    fun logout(@Header("Authorization") api_token: String?): Call<User?>?
}