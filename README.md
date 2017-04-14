# Retrofit

>Retrofit是Square公司开发的一款针对Android网络请求的框架，Retrofit2底层基于OkHttp实现的，OkHttp现在已经得到Google官方认可，大量的app都采用OkHttp做网络请求，其源码详见OkHttp Github。

##Gradle引入

compile 'com.squareup.retrofit2:retrofit:2.2.0'

##Jar

Download [the latest JAR][1] or grab via Maven:

###GitHub（square）

https://github.com/square/retrofit

>Demo数据全部来自本地数据（PHP）

##Code
##Get请求
```
Get不传参返回Response:
php-code:
$arr = array('name'=>'张力文','age'=>'25','sex'=>'男');
print_r(json_encode($arr));

java-code:
//Get不传参返回Response
  @GET("mytest.php")
  Call<MyTest> getSearchBooks();
         /**
         * Get不传参返回Json
         */
        call = service.getSearchBooks();
        call.enqueue(new Callback<MyTest>() {
            @Override
            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body
                        ().getAge().toString()+"   "+response.body().getSex().toString());
            }

            @Override
            public void onFailure(Call<MyTest> call, Throwable t) {
                text.setText("onFailure:" + t.toString());
            }
        });
```
```
Get传参返回Json:
Php-code：
$name = $_REQUEST['name'];
$age = $_REQUEST['age'];
$sex = $_REQUEST['sex'];
$arr = array('name'=>$name,'age'=>$age,'sex'=>'sex');
print_r(json_encode($arr));

java-code：
1.先写一个接口用来标注请求的方式，跟传递阐述的类型
 @GET("mytest.php")
 Call<MyTest> getSearchBooks(@Query("name") String name,@Query("age") String age,@Query("sex") String sex);
2.写一个解析实体类
3.核心处理代码
//get传参
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BlueService service = retrofit.create(BlueService.class);
        call = service.getSearchBooks("张三", "25", "男");
                call.enqueue(new Callback<MyTest>() {
                    @Override
                    public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                        text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body().getAge()
                                .toString()+"   "+response.body().getSex().toString());
                    }

                    @Override
                    public void onFailure(Call<MyTest> call, Throwable t) {

                    }
                });
```
```
@QueryMap方式将所有的参数集成在一个Map统一传递:
php-code:
$data = $_REQUEST;  
print_r(json_encode($data));

java-code:
//@QueryMap
    @GET("mytest.php")
    Call<MyTest> getSearchBooks(@QueryMap Map<String, String> options);

 /**
         *  @QueryMap
         *  @QueryMap方式将所有的参数集成在一个Map统一传递
         */
        Map<String, String> options = new HashMap<>();
        options.put("name", "张力文");
        options.put("age", "25");
        options.put("sex", "男");
        Call<MyTest> call = service.getSearchBooks(options);
        call.enqueue(new Callback<MyTest>() {
            @Override
            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                text.setText("异步请求结果: " + response.body().getName().toString()+"   "+response.body
                                               ().getAge().toString()+"   "+response.body().getSex().toString());
            }

            @Override
            public void onFailure(Call<MyTest> call, Throwable t) {
                text.setText("onFailure:" + t.toString());
            }
        });
```
```
Get传参,Query非必填:
php-code:
$name = $_REQUEST['name'];
$arr = array('name'=>$name);
print_r(json_encode($arr));

java-code:
//Query非必填
    @GET("mytest.php")
    Call<MyTest> getSearchBooks(@Query("name") String name,@Query("age") String age);

        /**
         *  Get传参,Query非必填
         */
        call = service.getSearchBooks("张力文", null);
        call.enqueue(new Callback<MyTest>() {
            @Override
            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                text.setText("异步请求结果: " + response.body().getName().toString());
            }

            @Override
            public void onFailure(Call<MyTest> call, Throwable t) {
                text.setText("onFailure:" + t.toString());
            }
        });
```
##Post请求
```
post请求传参返回Json
@field

php-code：
$name = $_REQUEST['name'];
$age = $_REQUEST['age'];
$sex = $_REQUEST['sex'];
$arr = array('name'=>$name,'age'=>$age,'sex'=>$sex);
print_r(json_encode($arr));

java-code：
//post请求传参返回Response @field
    @FormUrlEncoded
    @POST("mytest.php")
    Call<MyTest> addReviews(@Field("name") String name, @Field("age") String age,
                            @Field("sex") String sex);

/**
         * @field
         * post请求传参返回Json
         */
        call = service.addReviews("张力文","25","男");
                call.enqueue(new Callback<MyTest>() {
                    @Override
                    public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                        text.setText("异步请求结果: " + response.body().getName().toString() + "   " + response.body
                                ().getAge().toString()+"   "+response.body().getSex().toString());
                    }

                    @Override
                    public void onFailure(Call<MyTest> call, Throwable t) {
                        text.setText("onFailure:" + t.toString());
                    }
                });
```
```
 @FieldMap
post请求传集合返回Json:

php-code:
$data = $_REQUEST;  
print_r(json_encode($data));

java-code:
//@FieldMap post传集合
    @FormUrlEncoded
    @POST("mytest.php")
    Call<MyTest> addReviews(@FieldMap Map<String, String> fields);

/**
         * @FieldMap
         * post请求传集合返回Json
         */
        Map<String, String> fields = new HashMap<>();
        fields.put("name", "张力文");
        fields.put("age", "25");
        fields.put("sex", "男");
        Call<MyTest> call = service.addReviews(fields);
        call.enqueue(new Callback<MyTest>() {
            @Override
            public void onResponse(Call<MyTest> call, Response<MyTest> response) {
                text.setText("异步请求结果: " + response.body().getName().toString() + "   " + response.body
                        ().getAge().toString() + "   " + response.body().getSex()
                        .toString());
            }

            @Override
            public void onFailure(Call<MyTest> call, Throwable t) {
                text.setText("onFailure:" + t.toString());
            }
        });
```














[1]:https://search.maven.org/remote_content?g=com.squareup.retrofit2&a=retrofit&v=LATEST
