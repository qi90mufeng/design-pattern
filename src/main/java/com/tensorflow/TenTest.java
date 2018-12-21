package com.tensorflow;

import org.apache.commons.io.IOUtils;
import org.tensorflow.*;

import java.io.FileInputStream;

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
 * @version v 0.1
 * @date 2018-12-21
 */
public class TenTest {
//    public static void main(String[] args) throws Exception {
//        try (Graph g = new Graph()) {
//            final String value = "Hello from " + TensorFlow.version();
//
//            // Construct the computation graph with a single operation, a constant
//            // named "MyConst" with a value "value".
//            try (Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
//                // The Java API doesn't yet include convenience functions for adding operations.
//                g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();
//            }
//
//            // Execute the "MyConst" operation in a Session.
//            try (Session s = new Session(g);
//                 Tensor output = s.runner().fetch("MyConst").run().get(0)) {
//                System.out.println(new String(output.bytesValue(), "UTF-8"));
//            }
//        }
//
//    }

    public static void main(String[] args) throws Exception {
//        try (Graph graph = new Graph()) {
//            //导入图
//            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream("D:/github/design-pattern/src/main/resources/tensorflow/test.pb"));
//            graph.importGraphDef(graphBytes);
//
//            //根据图建立Session
//            try(Session session = new Session(graph)){
//                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
//                float z = session.runner()
//                        .feed("x", Tensor.create(10.0f))
//                        .fetch("z").run().get(0).floatValue();
//                System.out.println("z = " + z);
//            }
//        }


    }
}
