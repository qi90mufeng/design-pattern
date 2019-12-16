package com.jvm;

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
 * //         佛祖保佑       永无BUG     永不修改                    //
 * ////////////////////////////////////////////////////////////////////
 *
 * @author fujin
 * @version v 0.1
 * @date 2019-12-16
 */
public class EscapeAnalysisTest {
    /**
     * 逃逸分析和栈上分配
     */
    private EscapeAnalysisTest obj;

    /**
     * 逃逸的
     * @return
     */
    public EscapeAnalysisTest getInstance(){
        return obj == null ? new EscapeAnalysisTest() : obj;
    }
    /**
     * 逃逸的
     * @return
     */
    public void setObj(){
        this.obj = new EscapeAnalysisTest();
    }

    /**
     * 没有逃逸的，进行栈上分配
     * @return
     */
    public void useEscapeAnalysisTest(){
        EscapeAnalysisTest escapeAnalysisTest = new EscapeAnalysisTest();
    }
}
