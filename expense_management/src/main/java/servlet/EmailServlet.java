package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.js.sju.util.EmailUtil;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/EmailServlet"})
public class EmailServlet extends HttpServlet {
	private String email;  // ��ȡ���ռ�������
	private String vCode;  // ��̨��������֤��
	private String vCodeReceive;  // ���յ�ǰ���������֤��
	private String method;  // Ҫ���յķ���
	private PrintWriter out;  // �����
	private EmailUtil emailUtil = EmailUtil.instance;
	public EmailServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("��ʼ��");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	/*
	 * �ڴ�ʵ��servlet
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		//���Ա���
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		out = resp.getWriter();
		// ��ȡ����ǰ�˵Ĳ���
		email = req.getParameter("email");
		vCodeReceive = req.getParameter("vcode");
		method = req.getParameter("method");
		System.out.println(email+vCodeReceive+method);
		
		switch (method) {
		case "getVCode":
			mGetVCode();
			break;
		case "verify":
			mVerify();
			break;
		default:
			break;
		}
		
		out.flush();
		out.close();
	}

	/*
	 * ������֤�룬�������ʼ�
	 */
	private void mGetVCode() {
		// TODO Auto-generated method stub
		if(!isEmail(email)) {  // ���䲻��ȷ
			out.print(-1);
			return;
		}
		try {
			emailUtil.sendEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vCode = emailUtil.getVCode();
		System.out.println("��֤��Ϊ��" + vCode);
		out.print(1);
	}
	
	/*
	 * ������ȷ�Լ��
	 * @param �����ַ���
	 * @return true/false
	 */
	private boolean isEmail(String email) {
		if(email.length() == 0 || email == null) {
			return false;
		}
		// ������ʽ��֤����
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
		return pattern.matcher(email).matches();
	}
	
	/*
	 * ��֤����֤
	 */
	private void mVerify() {
		// TODO Auto-generated method stub
		if(vCode.equals(vCodeReceive)) {
			out.print(1);
		}
		else {
			out.print(-1);
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
}