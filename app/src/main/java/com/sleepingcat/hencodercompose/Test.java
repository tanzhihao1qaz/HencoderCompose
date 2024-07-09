package com.sleepingcat.hencodercompose;

import java.util.Scanner;

/**
 * @作者 志浩
 * @时间 2024/4/18 11:44
 * @描述 TODO
 */
class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextByte()) {
            char c = (char) in.nextByte();
            sb.append(c);
        }
        String str = sb.toString();
        char[] chars = str.toCharArray();
        for (int a = 0; a < chars.length; a++) {
            for (int b = 0; b < chars.length; b++) {
                if (chars[b] > chars[b + 1]) {
                    char temp = chars[b];
                    chars[b] = chars[b + 1];
                    chars[b + 1] = temp;
                }
            }
        }
        System.out.print("abcd");
    }
}