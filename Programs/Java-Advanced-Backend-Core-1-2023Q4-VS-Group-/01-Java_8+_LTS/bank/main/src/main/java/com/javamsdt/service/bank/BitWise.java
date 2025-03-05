package com.javamsdt.service.bank;

public class BitWise {
    public static void main(String[] args) {
        int num1 = -8;
        System.out.println(Integer.toBinaryString(num1));

        int num1Bite = num1 >> 1;
        System.out.println(num1Bite);
        System.out.println(Integer.toBinaryString(num1Bite));

        int num1BiteMore = num1 >>> 1;
        System.out.println(num1BiteMore);
        System.out.println(Integer.toBinaryString(num1BiteMore));

        System.out.println('b' + 'i' + 't');
    }
}
