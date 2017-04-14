package retrofit.jack.com.retrofit;

import java.util.List;

/**
 * Created by zhangliwen on 2017/4/11.
 */

public class MyTest {


    /**
     * name : 张三
     * age : 20
     * sex : 男
     */

    private String name;
    private String age;
    private String sex;
    private List<String> user;

    public List<String> getUser() {
        return user;
    }

    public void setUser(List<String> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
