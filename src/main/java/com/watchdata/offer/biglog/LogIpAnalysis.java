package com.watchdata.offer.biglog;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 花开
 * @create 2020-05-22 23:11
 * @desc
 **/
public class LogIpAnalysis {

    public Map<Integer,PrintWriter> bwp = new ConcurrentHashMap<>();

    public Map<Integer, List<String>> bwl = new ConcurrentHashMap<>();

    public Set<IP> set = new TreeSet<>();

    public void createLog(int num){
        File file = new File("d://log/ip.log");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            Random random = new Random();
            for (int i = 0; i < num;i++){
                for (int J = 0; J < 1000;J++){
                    printWriter.println(random.nextInt(255)+"." + random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255));

                }
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void spliLog(int num) throws IOException {
        File file = new File("d://log/ip.log");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        for (int i = 0; i < num;i++){
            File file1 = new File("D:\\log\\spliglog\\" + i + ".log");
            if (file1 .exists()){
                file1.delete();
            }
              file1.createNewFile();
            bwp.put(i,new PrintWriter(new FileWriter(file1)));
            List<String> list = new ArrayList<>();
            bwl.put(i,list);
        }

        String ip = bufferedReader.readLine();
        while (ip != null){
            int line = (ip.hashCode() > 0?ip.hashCode() : -ip.hashCode())%num;
            List<String> list = bwl.get(line);
            list.add(ip);
            if (list.size() % 1000 == 0){
                PrintWriter printWriter = bwp.get(line);
                for (String s : list) {
                    printWriter.println(s);
                }
                printWriter.flush();
                list.clear();
            }


           ip = bufferedReader.readLine();
        }

        bufferedReader.close();

        Set<Integer> integers = bwp.keySet();
        for (Integer line : integers) {
            PrintWriter printWriter = bwp.get(line);

            List<String> ipList = bwl.get(line);
            if (ipList.size() > 0){
                for (String s : ipList) {
                    printWriter.println(s);

                }
                printWriter.flush();
                ipList.clear();
            }
           printWriter.close();
        }

    }


    public void analystTopIp(File file) throws IOException {

        System.out.println(file.getName());

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String ip = bufferedReader.readLine();
            Set<IP> set1 = new TreeSet<>();
            while (ip != null){
                set1.add(new IP(ip,1));
                if (ip.equals("250.43.68.230")){
                    System.out.println(ip);
                }
                ip = bufferedReader.readLine();
            }
            bufferedReader.close();
            int i = 1;

            for (IP ip1 : set1) {
                set.add(ip1);
                if (i > 100){
                    break;
                }

                i++;
            }

            int n = 1;

        Set<IP> set2 = new TreeSet();
        for (IP ip2 : set) {
            set2.add(ip2);
            if (n > 100){
                break;
            }
            n ++ ;
        }

        set = set2;




    }

    public static void main(String[] args) throws IOException {
       long l = System.currentTimeMillis();
    LogIpAnalysis logIpAnalysis = new LogIpAnalysis();
   // logIpAnalysis.createLog(1000);
       logIpAnalysis.spliLog(1024);

         File file = new File("D:\\log\\spliglog");
        File[] files = file.listFiles();
        for (File file1 : files) {
            logIpAnalysis.analystTopIp(file1);
        }
        for (IP IP : logIpAnalysis.set){
            System.out.println(IP);
        }
        //  logIpAnalysis.spliLog();

 /*
        //ForkJoin实现
       long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();//实现ForkJoin 就必须有ForkJoinPool的支持
        ForkJoinTask<Long> task = new ForkJoinWork(0,15000);//参数为起始值与结束值
        Long invoke = forkJoinPool.invoke(task);*/
        long l1 = System.currentTimeMillis();
        System.out.println("  time: " + (l1-l));

    }
}
