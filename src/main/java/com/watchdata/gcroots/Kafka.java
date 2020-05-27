package com.watchdata.gcroots;

import com.watchdata.enumt.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author 花开
 * @create 2020-05-24 21:08
 * @desc kafka
 **/
public class Kafka {

    // 强应用
    public static Test test = new Test();

    // 软应用
    public static SoftReference<Test> softReference = new SoftReference<>(new Test());

    // 虚引用
    public static WeakReference<Test> weakReference = new WeakReference<>(new Test());




}
