package control;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class CheckNumber extends TagSupport{
	private String num;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(num);
		JspWriter out=pageContext.getOut();
		if(n%2==0) {
			try {out.println("<b>Even Number...</b>");}catch(Exception e) {}
		}
		else {
			try {out.println("<b>Odd Number...</b>");}catch(Exception e) {}
		}
		return 1;
	}
}