

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "jdbc:mysql://localhost:3306/YourDatabase";
		String user = "username";
		String pass = "password";
	
		
		String sql = "SELECT * FROM Details WHERE email = ? AND pass_word = ?";
		String errorMessage = null;
		String success = null;
		try 
		{
			Connection con = DriverManager.getConnection(url, user, pass);
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				success = "Successfully Login!";
				request.setAttribute("success", success);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			else 
			{
				errorMessage = "Invalid email or password";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		catch(SQLException e)
		{
			errorMessage = "Database error " + e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
