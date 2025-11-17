

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
import java.io.IOException;

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
		String btn1=request.getParameter("mybtn");
		String btn2=request.getParameter("getid");
	    

		if(btn1 !=null && btn1.equals("get")) {
	    
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:8580/tp1_ex2/RestApi/etudiant");
		Response resp=target.request().get();
		resp.bufferEntity();
		if(resp.getStatus()==200) {
			String res=resp.readEntity(String.class);
			response.getWriter().append(res);
		} else {
            response.getWriter().append("error");

        }}
		
		else if(btn2 !=null && btn2.equals("getid")) {
		Client client=ClientBuilder.newClient();
		int id = Integer.parseInt(request.getParameter("id"));
		WebTarget target=client.target("http://localhost:8580/tp1_ex2/RestApi/etudiant/" +id);
		Response resp=target.request().get();
		resp.bufferEntity();
		if(resp.getStatus()==200) {
			String res=resp.readEntity(String.class);
			response.getWriter().append(res);
		}} else {
			
            response.getWriter().append(" Étudiant avec cette  id non trouvé");
        }}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn3=request.getParameter("ajouter");
		String btn4=request.getParameter("modifier");
		String btn5=request.getParameter("supprimer");
		
		
		if(btn3 !=null && btn3.equals("ajouter")) {
	    int id=Integer.parseInt(request.getParameter("id"));
	    String nom=request.getParameter("nom");
	    double moyenne=Double.parseDouble(request.getParameter("moyenne"));
		Client client=ClientBuilder.newClient();
		etudiant e1=new etudiant(id,nom,moyenne);
		WebTarget target=client.target("http://localhost:8580/tp1_ex2/RestApi/etudiant");
		Response resp = target.request().post(Entity.json(e1));
		resp.bufferEntity();
		
		if(resp.getStatus()==200) {
			String res=resp.readEntity(String.class);
			response.getWriter().append(res);
		} else {
            response.getWriter().append("Étudiant non ajouté ");
        }}
		
		else if(btn4 !=null && btn4.equals("modifier")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			double moyenne=Double.parseDouble(request.getParameter("moyenne"));

			Client client=ClientBuilder.newClient();
			if (id <= 0 ) {
		        response.getWriter().append("ID invalide");
		        return;
		    }
			etudiant e1=new etudiant(id,nom,moyenne);
			WebTarget target=client.target("http://localhost:8580/tp1_ex2/RestApi/etudiant");
			Response resp = target.request().put(Entity.json(e1));
			resp.bufferEntity();
			
			if(resp.getStatus()==200) {
				String res=resp.readEntity(String.class);
				response.getWriter().append(res);
			} else {
	            response.getWriter().append("Étudiant non modifié");
	        }
		}
		else if(btn5 !=null && btn5.equals("supprimer")) {
			 try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            
		            if (id <= 0) {
		                response.getWriter().append("ID invalide");
		                return;
		            }
		            
		            Client client = ClientBuilder.newClient();
		            WebTarget target = client.target("http://localhost:8580/tp2_ex1/RestApi/etudiant/" + id); 
		            
		            Response resp = target.request().delete();
		            
		            if(resp.getStatus() == 200) {
		                String res = resp.readEntity(String.class);
		                response.getWriter().append(res);
		            } else {
		                response.getWriter().append("Échec de suppression ");
		            }
		        } catch (NumberFormatException | NullPointerException e) {
		            response.getWriter().append("ID invalide pour la suppression");
		        }
		    }
		}
	}
