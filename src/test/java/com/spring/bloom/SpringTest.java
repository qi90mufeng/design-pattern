package com.spring.bloom;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.spring.strategy.StrategyChain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //         佛祖保佑       永无BUG     永不修改                      //
 * ////////////////////////////////////////////////////////////////////
 *
 * @author fujin
 * @version $Id: SpringTest.java, v 0.1 2018-09-03 Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-annotation.xml"})
public class SpringTest {

    @Test
    public void test(){
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1000* 1000,
                0.01
        );
        for (int i = 0; i < 10000000; i++){
            filter.put(i);
        }

        System.out.println(filter.mightContain(20000000));
    }


    @Test
    public void split(){
        String dtr= "123456我";
        char[] a = dtr.toCharArray();
        for (char aa:a){
            System.out.println(aa);
        }
    }
}
