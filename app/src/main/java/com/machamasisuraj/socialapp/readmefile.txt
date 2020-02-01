@Headers({ "Content-Type: application/json;charset=UTF-8"})
@GET("api/Profiles/GetProfile")
Call<UserProfile> getUser(@Query("id") String id, @Header("Authorization") String auth);