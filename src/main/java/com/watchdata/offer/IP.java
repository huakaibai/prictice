package com.watchdata.offer;

import lombok.ToString;

import java.util.Set;
import java.util.TreeSet;

@ToString
class IP implements Comparable<IP>{
	public String ip;
	public int nums;
	public IP(){}
	public IP(String ip,int nums){
		this.ip = ip;
		this.nums = nums;
	}
	@Override
	public int compareTo(IP o) {
		if (this.ip.equals(o.ip)) {
			o.nums=this.nums+o.nums;
		}else {
			if (this.nums > o.nums) {
				return -1;
			}else{
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Set<IP> set = new TreeSet<>();
    /*    set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("192",1));*/
		set.add(new IP("192",1));
		set.add(new IP("192",1));
		set.add(new IP("193",1));
		set.add(new IP("192",1));
		set.add(new IP("192",1));
		set.add(new IP("194",1));
		set.add(new IP("193",1));

		for (IP ip : set) {
			System.out.println(ip);
		}
	}
}
