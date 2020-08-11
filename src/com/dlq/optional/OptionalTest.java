package com.dlq.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 *
 * 常用方法：ofNullable(T t)
 *          orElse(T t)
 */
public class OptionalTest {

    /**
      1、Optional.of(T t) :创建一个Optional实例，t必须非空；
      2、Optional.empty() :创建一个空的Optional实例
      3、Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1() {
        Girl girl = new Girl();
        //girl = null; /*java.lang.NullPointerException*/
        //of(T t)：保证t是非空的，否则空指针
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl=null; /*Optional.empty*/
        //ofNullable(T t)：t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl); /*如果girl=null;Optional.empty。否则 Optional[Girl{name='null'}]。*/
        //orElse(T t1)：如果当前的Optional内部封装的t是非空的，则返回内部的t。
        //             如果内部的t是空的，则返回orElse()方法中的t1.
        Girl girl1 = optionalGirl.orElse(new Girl("你好啊"));
        System.out.println(girl1);
    }

    //场景测试：
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy =null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName()：
    public String getGirlName1(Boy boy){
        if (boy !=null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }
    @Test
    public void test4() {
        Boy boy = new Boy();
        boy =null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName()：
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("范冰冰"));

        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy = null; /*迪丽热巴*/
        boy=new Boy(); /*范冰冰*/
        boy = new Boy(new Girl("杨幂")); /*杨幂*/
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
