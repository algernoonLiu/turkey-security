package com.algernoon.turkeysecurity;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		BigDecimal result = new BigDecimal(1);
		for (int i = 1; i <= 100; i++) {
			BigDecimal i_value = new BigDecimal(i);
			result = result.multiply(i_value);
		}
		System.out.println("result=" + result);
	}

}
