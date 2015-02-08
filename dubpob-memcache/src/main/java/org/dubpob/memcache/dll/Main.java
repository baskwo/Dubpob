package org.dubpob.memcache.dll;

import org.dubpob.memcache.dll.DllFactory.CLibrary;

public class Main {
	public static void main(String[] args) {
		System.out.println(CLibrary.INSTANCE.getpid());
	}
}
