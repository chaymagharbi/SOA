

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import wk1.meteo;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn1=request.getParameter("btn1");//name
		String btn2=request.getParameter("btn2");
		//equals:value
		if(btn1 !=null && btn1.equals("getall")) {
			Client client=ClientBuilder.newClient();
			WebTarget target=client.target("http://localhost:8580/tp1_ex1/RestApi/meteo");
			Response resp= target.request().get();
			resp.bufferEntity();
			if(resp.getStatus()==200) {
				String res= resp.readEntity(String.class);
				response.getWriter().append(res);
			}else {
				response.getWriter().append("echec de get all");
			}
		}
		
		else if (btn2 !=null && btn2.equals("get") ) {
			String ville=request.getParameter("ville");
			Client client=ClientBuilder.newClient();
			WebTarget target=client.target("http://localhost:8580/tp1_ex1/RestApi/meteo/" +ville);
			Response resp=target.request().get();
			resp.bufferEntity();
			if(resp.getStatus()==200) {
				String res=resp.readEntity(String.class);
				response.getWriter().append(res);
			}else {
				response.getWriter().append("can not get ville ");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn3=request.getParameter("btn3");
		
		if(btn3 != null && btn3.equals("ajouter")) {
			Client client =ClientBuilder.newClient();
			WebTarget target=client.target("http://localhost:8580/tp1_ex1/RestApi/meteo");
			String ville=request.getParameter("ville");
			LocalDate date = LocalDate.parse(request.getParameter("date"));
			double mesure=Double.parseDouble(request.getParameter("temp"));
			meteo m1=new meteo(ville,date,mesure);
			Response resp=target.request().post(Entity.json(m1));
			
			if(resp.getStatus()==200) {
				String res=resp.readEntity(String.class);
				response.getWriter().append(res);
			}else {
				response.getWriter().append("erreur ajout meteo");
			}
		}
	}

}
