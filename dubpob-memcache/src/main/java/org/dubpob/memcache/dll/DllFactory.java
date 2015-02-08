package org.dubpob.memcache.dll;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class DllFactory {
	static interface CLibrary extends Library {
		public static CLibrary INSTANCE = (CLibrary) Native.loadLibrary("c", CLibrary.class);
	
		public int getpid();
	}
}
