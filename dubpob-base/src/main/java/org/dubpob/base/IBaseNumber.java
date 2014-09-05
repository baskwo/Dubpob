package org.dubpob.base;

public interface IBaseNumber {
	public String getHexValue();
	public long getOctValue();
	public long getDecValue();
	public long getBinValue();
	
	public void addHex(String value);
	public void addOct(long value);
	public void addDec(long value);
	public void addBin(long value);
	
	public void subHex(String value);
	public void subOct(long value);
	public void subDec(long value);
	public void subBin(long value);
	
	public void mulHex(String value);
	public void mulOct(long value);
	public void mulDec(long value);
	public void mulBin(long value);
	
	public void divHex(String value);
	public void divOct(long value);
	public void divDec(long value);
	public void divBin(long value);
}
