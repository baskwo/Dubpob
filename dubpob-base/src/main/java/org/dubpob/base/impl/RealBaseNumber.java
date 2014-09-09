package org.dubpob.base.impl;

public class RealBaseNumber {
	private byte format = 10;
	private long decVal = 0L;
	
	private RealBaseNumber(byte format) {
		if(format > 62 || format < 2) {
			try {
				throw new Exception("The format specified is great than 62 or less than 2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.format = format;
	}
	
	public static RealBaseNumber fromBase(byte format) {
		return new RealBaseNumber(format);
	}
	
	public String getValue() {
		StringBuilder builder = new StringBuilder();
		long val = decVal;
		long quotient = 0L;
		int remain = 0;
		do{
			remain = (int) (val % format);
			val /= format;
			quotient = val;
			if(remain < 10)
				builder.append(remain);
			else{
				remain -= 10;
				char toHex = 'A';
				for(int i = remain; i > 0; i--) {
					if(toHex == 'Z') {
						toHex = 'a';
						continue;
					}
					toHex++;
				}
				builder.append(toHex);
			}
		}while(quotient != 0);
		builder.reverse();
		return builder.toString();
	}
	
	public void add(RealBaseNumber number) {
		decVal += number.decVal;
	}
	public void sub(RealBaseNumber number) {
		decVal -= number.decVal;
	}
	public void mul(RealBaseNumber number) {
		decVal *= number.decVal;
	}
	public void div(RealBaseNumber number) {
		decVal /= number.decVal;
	}

	public byte getFormat() {
		return format;
	}

	public void setFormat(byte format) {
		this.format = format;
	}

	public long getDecVal() {
		return decVal;
	}

	public void setDecVal(long decVal) {
		this.decVal = decVal;
	}
}
