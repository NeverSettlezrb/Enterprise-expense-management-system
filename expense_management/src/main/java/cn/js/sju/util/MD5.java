package cn.js.sju.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.chainsaw.Main;

//��MD5����
//��������ַ������ܳ�32λ��16���Ƶ��ַ���
public class MD5 {

	public String getMD5Encoding(String password) {
		
		//����md5���ܼ�����
		MessageDigest md5 = null;
	
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		md5.update(password.getBytes());
		return new BigInteger(1, md5.digest()).toString(16);
		
	}
//	public static void main(String[] args) {
//		String se = "123456";
//		MD5 md5 = new MD5();
//		String use = md5.getMD5Encoding(se);
//		System.out.println(use);
//	}
}
