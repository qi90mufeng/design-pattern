package com.jvm.sandbox;

import java.io.FilePermission;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedAction;

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
 * @date 2019-12-18
 */
public class CustomURLClassLoader extends URLClassLoader {

    public CustomURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
        //特权代码，设置验证管理器
        AccessController.doPrivileged((PrivilegedAction) () -> {
            System.setSecurityManager(CustomSecurityManager.INSTANCE);
            return null;
        });
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource){
        Permissions p = new Permissions();
        p.add(new AllPermission());
        return super.getPermissions(codesource);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    static class CustomSecurityManager extends SecurityManager{
        public static CustomSecurityManager INSTANCE = new CustomSecurityManager(){};

        private CustomSecurityManager(){}

        private void sandboxChcek(Permission perm) throws SecurityException{
            if (perm instanceof FilePermission){
                return;
            }
            super.checkPermission(perm);
        }

        @Override
        public void checkPermission(Permission perm) {
           this.sandboxChcek(perm);
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            super.checkPermission(perm, context);
        }
    }
}
