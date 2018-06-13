import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Backend
 */
@WebServlet("/Backend")
public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Datenbank datenbank;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backend() {
        super();
        datenbank = new Datenbank();
        System.out.println("Datenbank erfolgreich erstellt");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Buch buch = new Buch();
		
		buch.setBuchtitel(request.getParameter("buchtitel"));
		buch.setAutor(request.getParameter("autor"));
		buch.setKategorie(request.getParameter("kategorie"));
		buch.setBuchart(request.getParameter("buchart"));
		buch.setVerlag(request.getParameter("verlag"));
		buch.setSprache(request.getParameter("sprache"));
		buch.setIsbn10(request.getParameter("isbn10"));
		buch.setIsbn13(request.getParameter("isbn13"));
		buch.setHoehe(request.getParameter("hoehe"));
		buch.setBreite(request.getParameter("breite"));
		buch.setTiefe(request.getParameter("tiefe"));
		buch.setPreis(request.getParameter("preis"));
		buch.setBuchdetails(request.getParameter("buchdetails"));

		out.println("<!DOCTYPE html><HTML>\n" +
					"<HEAD><link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
					"\r\n" + 
					" <link href=\"css/heroic-features.css\" rel=\"stylesheet\"><TITLE>Bucheingabe</TITLE></HEAD>\n" +
					"<BODY>\n");
		
		//Überprüfung contains!!
		if(!datenbank.contains(buch)) {
			out.println("<H1>Buch wurde hinzugefügt!</H1>\n" +
						"<p>" + datenbank.add(buch) + "</p>");
		} else {
			out.println("<H1>Buch konnte nicht hinzugefügt werden!</H1>\n");
		}
		
		out.println("<a href=\"bucheingabe.html\" class=\"btn btn-primary\">Neues Buch</a>"
				+ "<a href=\"index.html\" class=\"btn btn-primary\">Home</a>" +
					"</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
