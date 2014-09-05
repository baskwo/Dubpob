package org.dubpob.base.impl;

import org.dubpob.base.IBaseNumber;

public class SimpleBaseNumber implements IBaseNumber {
	private long value = 0L;
	
	@Override
	public String getHexValue() {
		StringBuilder builder = new StringBuilder();
		long val = value;
		long quotient = 0L;
		int remain = 0;
		do{
			remain = (int) (val % 16);
			val /= 16;
			quotient = val;
			if(remain < 10)
				builder.append(remain);
			else{
				remain -= 10;
				char toHex = 'A';
				for(int i = remain; i > 0; i--) {
					toHex++;
				}
				builder.append(toHex);
			}
		}while(quotient != 0);
		builder.reverse();
		return builder.toString();
	}

	@Override
	public long getOctValue() {
		StringBuilder builder = new StringBuilder();
		long val = value;
		long quotient = 0L;
		do{
			builder.append(val % 8);
			val /= 8;
			quotient = val;
		}while(quotient != 0);
		builder.reverse();
		return Long.parseLong(builder.toString());
	}
	
	@Override
	public long getDecValue() {
		return value;
	}

	@Override
	public long getBinValue() {
		StringBuilder builder = new StringBuilder();
		long val = value;
		long quotient = 0L;
		do{
			builder.append(val % 2);
			val /= 2;
			quotient = val;
		}while(quotient != 0);
		builder.reverse();
		return Long.parseLong(builder.toString());
	}

	@Override
	public void addHex(String value) {
		StringBuilder oct = new StringBuilder(value);
		oct.reverse();
		long decVal = 0L;
		
		for(int i = 0; i < oct.length(); i++) {
			char c = oct.charAt(i);
			if(c >= '0' && c <= '9') {
				long val = Long.parseLong(""+c);
				decVal += val * Math.pow(16,i);
			}else {
				int toAdd = 0;
				while(c != 'A') {
					toAdd++;
					c--;
				}
				decVal += (10 + toAdd) * Math.pow(16, i);
			}
		}
		
		this.value += decVal;
	}

	@Override
	public void addOct(long value) {
		StringBuilder oct = new StringBuilder(Long.toString(value));
		oct.reverse();
		long decVal = 0L;
		
		for(int i = 0; i < oct.length(); i++) {
			char c = oct.charAt(i);
			long val = Long.parseLong(""+c);
			decVal += val * Math.pow(8,i);
		}
		
		this.value += decVal;
	}

	@Override
	public void addDec(long value) {
		this.value += value;
	}

	@Override
	public void addBin(long value) {
		StringBuilder oct = new StringBuilder(Long.toString(value));
		oct.reverse();
		long decVal = 0L;
		
		for(int i = 0; i < oct.length(); i++) {
			char c = oct.charAt(i);
			long val = Long.parseLong(""+c);
			decVal += val * Math.pow(2,i);
		}
		
		this.value += decVal;
	}

	@Override
	public void subHex(String value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addHex(value);
		this.value -= val.getDecValue();
	}

	@Override
	public void subOct(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addOct(value);
		this.value -= val.getDecValue();
	}

	@Override
	public void subDec(long value) {
		this.value -= value;
	}

	@Override
	public void subBin(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addBin(value);
		this.value -= val.getDecValue();
	}

	@Override
	public void mulHex(String value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addHex(value);
		this.value *= val.getDecValue();
	}

	@Override
	public void mulOct(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addOct(value);
		this.value *= val.getDecValue();
	}

	@Override
	public void mulDec(long value) {
		this.value *= value;
	}

	@Override
	public void mulBin(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addBin(value);
		this.value *= val.getDecValue();
	}

	@Override
	public void divHex(String value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addHex(value);
		this.value /= val.getDecValue();
	}

	@Override
	public void divOct(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addOct(value);
		this.value /= val.getDecValue();
	}

	@Override
	public void divDec(long value) {
		this.value /= value;
	}

	@Override
	public void divBin(long value) {
		IBaseNumber val = new SimpleBaseNumber();
		val.addBin(value);
		this.value /= val.getDecValue();
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
