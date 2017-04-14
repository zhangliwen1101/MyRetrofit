package retrofit.jack.com.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Call<MyTest> call;
    private String callStr;
    private TextView text;
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        //这里的baseUrl就是网络请求URL相对固定的地址，一般包括请求协议（如Http）、域名或IP地址、端口号等，当然还会有很多其他的配置，下文会详细介绍。
        // 还有addConverterFactory
        // 方法表示需要用什么转换器来解析返回值，GsonConverterFactory.create()表示调用Gson库来解析json返回值，具体的下文还会做详细介绍。
        //get传参
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BlueService service = retrofit.create(BlueService.class);
        /**
         *  Get传参
         */
        //        call = service.getSearchBooks("张三", "25", "男");
        //                call.enqueue(new Callback<MyTest>() {
        //                    @Override
        //                    public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                        text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body
        // ().getAge()
        //                                .toString()+"   "+response.body().getSex().toString());
        //                    }
        //
        //                    @Override
        //                    public void onFailure(Call<MyTest> call, Throwable t) {
        //
        //                    }
        //                });

        /**
         * Get不传参返回Json
         */
        //        call = service.getSearchBooks();
        //        call.enqueue(new Callback<MyTest>() {
        //            @Override
        //            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body
        //                        ().getAge().toString()+"   "+response.body().getSex().toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<MyTest> call, Throwable t) {
        //                text.setText("onFailure:" + t.toString());
        //            }
        //        });
        /**
         *  @QueryMap
         *  @QueryMap方式将所有的参数集成在一个Map统一传递
         */
        //        Map<String, String> options = new HashMap<>();
        //        options.put("name", "张力文");
        //        options.put("age", "25");
        //        options.put("sex", "男");
        //        Call<MyTest> call = service.getSearchBooks(options);
        //        call.enqueue(new Callback<MyTest>() {
        //            @Override
        //            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body
        //                                               ().getAge().toString()+"   "+response.body().getSex()
        // .toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<MyTest> call, Throwable t) {
        //                text.setText("onFailure:" + t.toString());
        //            }
        //        });
        /**
         *  Get传参,Query非必填
         */
        //        call = service.getSearchBooks("张力文", null);
        //        call.enqueue(new Callback<MyTest>() {
        //            @Override
        //            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                text.setText("异步请求结果: " + response.body().getName().toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<MyTest> call, Throwable t) {
        //                text.setText("onFailure:" + t.toString());
        //            }
        //        });
        ///////////////////////////////////////////////////post////////////////////////////////
        /**
         * @field
         * post请求传参返回Json
         */
        //        call = service.addReviews("张力文","25","男");
        //                call.enqueue(new Callback<MyTest>() {
        //                    @Override
        //                    public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                        text.setText("异步请求结果: " + response.body().getName().toString() + "   " + response.body
        //                                ().getAge().toString()+"   "+response.body().getSex().toString());
        //                    }
        //
        //                    @Override
        //                    public void onFailure(Call<MyTest> call, Throwable t) {
        //                        text.setText("onFailure:" + t.toString());
        //                    }
        //                });
        /**
         * @FieldMap
         * post请求传集合返回Json
         */
        //        Map<String, String> fields = new HashMap<>();
        //        fields.put("name", "张力文");
        //        fields.put("age", "25");
        //        fields.put("sex", "男");
        //        Call<MyTest> call = service.addReviews(fields);
        //        call.enqueue(new Callback<MyTest>() {
        //            @Override
        //            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
        //                text.setText("异步请求结果: " + response.body().getName().toString() + "   " + response.body
        //                        ().getAge().toString() + "   " + response.body().getSex()
        //                        .toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<MyTest> call, Throwable t) {
        //                text.setText("onFailure:" + t.toString());
        //            }
        //        });
    }
}
