package com.watchdata.offer;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;
public class LogAnalysis {
	//保存每个文件的流对象
	public final Map<Integer,BufferedWriter> bwMap = new HashMap<Integer,BufferedWriter>();
	//分隔文件用-存储相当数量之后再存入某个文件
	public final Map<Integer,List<String>> dataMap = new HashMap<Integer,List<String>>();
	//存储访问次数前100的IP
	public Set<IP> set = new TreeSet<IP>();

	// 生成日志文件
	public void creatLog(File log,long logNums) throws Exception{
		FileWriter fw = new FileWriter(log,true);
		BufferedWriter bw = new BufferedWriter(fw);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < logNums; i++) {
			bw.write("192."+random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)+"\n");
			if((i+1) % 1000 == 0){
				bw.flush();
			}
		}
		bw.flush();
		fw.close();
		bw.close();
	}

	// 分割日志文件
	public void splitLog(File logflie,int fileNums) throws Exception{
		FileReader fr = new FileReader(logflie);
		BufferedReader br =new BufferedReader(fr);
		String ip = br.readLine();
		//先创建文件及流对象方便使用
		for(int i=0;i<fileNums;i++){
			File file = new File("D:\\javasoft\\TempTest\\BigData\\logSplit\\"+ i + ".txt");
			bwMap.put(i, new BufferedWriter(new FileWriter(file,true)));
			dataMap.put(i, new LinkedList<String>());
		}
		while(ip != null){
			int hashCode = ip.hashCode();
			hashCode = hashCode < 0 ? -hashCode : hashCode;
			int fileNum = hashCode % fileNums;
			List<String> list = dataMap.get(fileNum);
			list.add(ip + "\n");
			if(list.size() % 1000 == 0){
				BufferedWriter writer = bwMap.get(fileNum);
				for(String line : list){
					writer.write(line);
				}
				writer.flush();
				list.clear();
			}
			ip = br.readLine();
		}
		for(int fn : bwMap.keySet()){
			List<String> list = dataMap.get(fn);
			BufferedWriter writer = bwMap.get(fn);
			for(String line : list){
				writer.write(line);
			}
			list.clear();
			writer.flush();
			writer.close();
		}
		bwMap.clear();
		fr.close();
		br.close();
	}

	//分析统计，找出次数前100的IP
	public void analysis(File logSplit) throws Exception{
		FileReader fr = new FileReader(logSplit);
		BufferedReader br =new BufferedReader(fr);
		String ip = br.readLine();
		//临时temp1存储当前文件所有IP
		Set<IP> temp1 = new TreeSet<IP>();
		while(ip != null){
			ip = ip.trim();
			temp1.add(new IP(ip,1));
			ip = br.readLine();
		}
		br.close();
		fr.close();
		//提取temp1存储当前文件访问次数前100的IP并将其与set合并
		int i=0;
		for (IP o : temp1) {
			set.add(o);
			if (i>=100) {
				break;
			}
			i++;
		}
		//临时temp2截取已经合并的set中前100的IP
		Set<IP> temp2 = new TreeSet<IP>();
		for (IP o : set) {
			temp2.add(o);
			if (i>=100) {
				break;
			}
			i++;
		}
		//使得set一直存储目前已经分析访问次数前100的IP
		set = temp2;
		temp2=null;
		temp1=null;
	}
}
