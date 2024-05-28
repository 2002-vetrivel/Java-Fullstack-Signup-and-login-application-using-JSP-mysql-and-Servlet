

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.io.*;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm_password");
		
		String errorMessage = null;
		String success  = null;
		
		if(!password.equals(confirm))
		{
			errorMessage = "Password does not match!";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			return;
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			
			String url = "jdbc:mysql://localhost:3306/YourDatabase";
			String user = "username"; //mysql username
			String pass = "password"; //mysql password
			
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO Details(username, email, pass_word, confirm_password) VALUES (?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, confirm);
			
			int result = ps.executeUpdate();
			
			if(result > 0)
			{
				success = "Successfully SignUp!";
				request.setAttribute("success", success);
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			}
		}
		catch(SQLException e)
		{
			errorMessage = "Database error" + e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
				if(ps != null)
				{
					ps.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
