package cn.js.sju.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	private static String fromEmail = "1366734774@qq.com";  // �������˺�
	private static String fromEmailPw = "qjwpterfxjdzbace";  // ����������
	private static String myEmailSMTPHost = "smtp.qq.com";  // �������������
	private static Properties props;  // ���ڲ�������
	private static Session session;  // ���ڴ����Ự����
	private String vCode;
	public static EmailUtil instance = new EmailUtil();
	
	/*
	 * ��ȡ��֤��
	 * @return ��֤���ַ���
	 */
	public String getVCode() {
		return vCode;
	}
	
	/*
	 * ���캯������������
	 */
	private EmailUtil() {
		props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");  // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);  // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");  // ��Ҫ������֤
        session = Session.getInstance(props);
        // session.setDebug(true);  // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log 
	}
	
	/*
	 * �����ʼ�����
	 * @param �ռ���
	 * @return �����ʼ�����
	 */
	public MimeMessage createMailContent(String toEmail) throws Exception, MessagingException {
		MimeMessage message = new MimeMessage(session);
		// ������
		message.setFrom(new InternetAddress(fromEmail, "��ҵ���ù���ϵͳ", "UTF-8"));
		// �ռ���
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
		// �ʼ�����
		message.setSubject("��֤��", "UTF-8");
		// �ʼ����� 
		vCode = VCodeUtill.verifyCode(6);
		message.setContent("���ã�������֤���ǣ�"+vCode+"��", "text/html;charset=UTF-8");
		// ���÷���ʱ��
		message.setSentDate(new Date());
		// ��������
		message.saveChanges();
		return message;
	}
	/*
	 * �����ʼ�
	 * @param �ռ���
	 */
	public void sendEmail(String toEmail) throws Exception {
		Transport transport = session.getTransport();
		transport.connect(fromEmail, fromEmailPw);
		MimeMessage message = createMailContent(toEmail);  // �ʼ�����
		transport.sendMessage(message, message.getAllRecipients());
		System.out.println("��֤�뷢�ͳɹ���");
		// �ر�����
		transport.close();
	}
}