package retrofit.jack.com.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhangliwen on 2017/4/11.
 */

public interface  BlueService {
    //这里需要稍作说明，@GET注解就表示get请求，@Query表示请求参数，将会以key=value的方式拼接在url后面
    //Get传参
    @GET("mytest.php")
    Call<MyTest> getSearchBooks(@Query("name") String name,@Query("age") String age,@Query("sex") String sex);
    //Get不传参返回Response
    @GET("mytest.php")
    Call<MyTest> getSearchBooks();
    //@QueryMap
    @GET("mytest.php")
    Call<MyTest> getSearchBooks(@QueryMap Map<String, String> options);
    //Query非必填
    @GET("mytest.php")
    Call<MyTest> getSearchBooks(@Query("name") String name,@Query("age") String age);
    ////////////////post请求/////////////////////////
    //post请求传参返回Response @field
    @FormUrlEncoded
    @POST("mytest.php")
    Call<MyTest> addReviews(@Field("name") String name, @Field("age") String age,
                            @Field("sex") String sex);
    //@FieldMap post传集合
    @FormUrlEncoded
    @POST("mytest.php")
    Call<MyTest> addReviews(@FieldMap Map<String, String> fields);

}
