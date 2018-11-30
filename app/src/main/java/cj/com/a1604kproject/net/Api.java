package cj.com.a1604kproject.net;


import cj.com.a1604kproject.bean.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserInfo> login(@Field("mobile") String mobile, @Field("password") String password);
}
