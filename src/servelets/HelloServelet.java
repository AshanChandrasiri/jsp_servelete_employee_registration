package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import controller.hibernate_controller;
import models.Employee;


@WebServlet("/helloServelet")
public class HelloServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static hibernate_controller hc;

       

    public HelloServelet() {
        super();
        
    }
    
    
    private void createSession(){
    	
    	if(HelloServelet.hc != null){
    		return;
    	}else{
    		HelloServelet.hc = new hibernate_controller();
    	}
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello clicked");
		
		String atr1 = request.getParameter("atr1");
		String atr2 = request.getParameter("atr2");
		String atr3 = request.getParameter("atr3");
		String atr4 = request.getParameter("atr4");
		
		createSession();
		try {
			if (request.getParameter("add") != null) {
				HelloServelet.hc.create(atr1,atr2,atr3);
			}
			else if (request.getParameter("remove") != null) {
				System.out.println("removeeeeeeeeeeeeeeedddddddddddddddddddddddd");
				String gi =request.getParameter("hdnbt");
				HelloServelet.hc.delete(Long.parseLong(gi));
				System.out.println("button value" +gi);	
			}
			else if (request.getParameter("update") != null) {	
				System.out.println("eeeeeeeeeddittttttttttttttt");
				HelloServelet.hc.update((Long.parseLong(atr4)), atr1, atr2, atr3);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("errorrrrr at dopost: " + e.getMessage());
		}finally {
			response.sendRedirect("/EmpTest2/helloServelet");
		}
		
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		createSession();
		
		List<Employee> list = HelloServelet.hc.getAllBooks();
		System.out.println("after click");
         
         req.setAttribute("list", list);
         req.getRequestDispatcher("").forward(req, resp);		
	}
	
	
	
	
	
	
	
	

}
