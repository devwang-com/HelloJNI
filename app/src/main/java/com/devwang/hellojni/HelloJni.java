/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devwang.hellojni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelloJni extends AppCompatActivity {
    private int[] aa = {1, 2, 3, 4, 5, 6};
    private double [] da = {1.0,2.0,3.0};
    private String [] sa = {"abcd","efgh","ijkl"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        TextView tv = new TextView(this);
        tv.setText(stringFromJNI());
        tv.setText("Hello Bruce !" + getFromJNI(1, 2));
        tv.setText(""
                +"Author: Bruce.Wang\n"
                +"Date:2016-01-08\n"
                +"Email:devwang.com@gmail.com\n"
                +"Site:http://www.devwang.com\n"
                +"Name:“study jni”\n"
                +"/*****************/\n"
                + "整数相加：" + addInt(1, 2) + "\n"
                + "实数相乘：" + mulDouble(1.2, 5.0) + "\n"
                + "实数大小：" + bigger(2, 1) + "\n"
                + "字符串拼接：" + addString("abcd", "efgh") + "\n"
                + "整型数组加：" + intArray(aa) + "\n"
                + "实数数组：" + doubleArray(da) +"\n"
                + "字符串倒序：" + stringArray(sa)+"\n");
        System.out.println("====BRUCE====>>:" + getFromJNI(2, 3));
        setContentView(tv);
    }

    /* A native method that is implemented by the
     * 'hello-jni' native library, which is packaged
     * with this application.
     */
    public native String stringFromJNI();

    public native int getFromJNI(int a, int b);

    //study jni
    public native int addInt(int a, int b);//输入整数，输出整数

    public native double mulDouble(double a, double b);//输入实数，输出实数

    public native boolean bigger(float a, float b);//输入float型实数，输出布尔值

    public native String addString(String a, String b);//输入字符串，输出字符串

    public native int[] intArray(int[] a);//输入整数数组，输出整数数组
    public native double[] doubleArray(double[] a);//输入实数数组，输出实数数组
    public native String[] stringArray(String[] a);//输入字符串数组，输的字符串数组


    /* This is another native method declaration that is *not*
     * implemented by 'hello-jni'. This is simply to show that
     * you can declare as many native methods in your Java code
     * as you want, their implementation is searched in the
     * currently loaded native libraries only the first time
     * you call them.
     *
     * Trying to call this function will result in a
     * java.lang.UnsatisfiedLinkError exception !
     */
    //public native String  unimplementedStringFromJNI();


    /* this is used to load the 'hello-jni' library on application
     * startup. The library has already been unpacked into
     * /data/data/com.example.hellojni/lib/libhello-jni.so at
     * installation time by the package manager.
     */
    static {
        System.loadLibrary("hellojni");
    }
}
