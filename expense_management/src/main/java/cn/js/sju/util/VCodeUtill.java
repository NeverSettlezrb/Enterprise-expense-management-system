package cn.js.sju.util;

import java.util.Random;

public class VCodeUtill {
	/*
	 * ����nλ�����֤�룬�������ֺʹ�Сд��ĸ
	 * @param ��֤�볤��
	 * @return nλ��֤��
	 */
	public static String verifyCode(int n) {
		StringBuilder strB = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			int r1 = rand.nextInt(3);
			int r2 = 0;
			switch (r1) {  // r2Ϊascii��ֵ
			case 0: // ����
				r2 = rand.nextInt(10) + 48;  // ���֣�48-57�������
				break;
			case 1:
				r2 = rand.nextInt(26) + 65;  // ��д��ĸ 
				break;
			case 2:
				r2 = rand.nextInt(26) + 97;  // Сд��ĸ 
				break;
			default:
				break;
			}
			strB.append((char)r2);
		}
		return strB.toString();
	}
}