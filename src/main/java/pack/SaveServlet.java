package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 response.setContentType("text/html");	
	 PrintWriter out=response.getWriter();
	 
	 String name=request.getParameter("uname");
	 String password=request.getParameter("upass");
	 String email=request.getParameter("uemail");
	 String city=request.getParameter("ucity");
	 String course=request.getParameter("ucourse");
	 
	 Emp e=new Emp();
	 e.setName(name);
	 e.setPassword(password);
	 e.setEmail(email);
	 e.setCity(city);
	 e.setCourse(course);
	 
	int status =EmpDao.save(e);
	if(status>0)
	{
	out.println("<h3>Save Successfully!!!</h3>");	
	request.getRequestDispatcher("index.html").include(request, response);
	}
	else 
	{
	out.println("Not save");
	}
	}
}
