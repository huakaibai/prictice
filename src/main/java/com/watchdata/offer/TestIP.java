package com.watchdata.offer;
import java.io.*;
public class TestIP {
	public static void main(String[] args) throws Exception{
		//生成模拟日志文件
		LogAnalysis logAnalysis = new LogAnalysis();
		File log = new File("D:\\javasoft\\TempTest\\BigData\\ip.txt");
		log.createNewFile();
		logAnalysis.creatLog(log, 10000);//节省时间

		//分割日志文件
		logAnalysis.splitLog(log, 1024);

		//分析文件
		File logSplits = new File("D:\\javasoft\\TempTest\\BigData\\logSplit");
		for (File logSplit : logSplits.listFiles()) {
			logAnalysis.analysis(logSplit);
		}
		for (IP o : logAnalysis.set) {
			System.out.println(o.ip+"---"+o.nums);
		}
	}
}
