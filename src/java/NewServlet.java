import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

/**
 *
 * @author Anna
 */
public class NewServlet extends HttpServlet {

    private static final long serialVersionUID =1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        String plec = request.getParameter("plec");
        String wiek = request.getParameter("wiek");
        String miejsce_zam = request.getParameter("miejsce_zam");
        String wzrost = request.getParameter("wzrost");
        String waga = request.getParameter("waga");
        String cisnienies = request.getParameter("cisnienies");
        String cisnienier = request.getParameter("cisnienier");
        String nadcisnienie = request.getParameter("nadcisnienie");
        String czynnik = request.getParameter("czynnik");
        String alkohol = request.getParameter("alkohol");
        String udar = request.getParameter("udar");
        String ktoraprzyczynasmierci = request.getParameter("ktoraprzyczynasmierci");
        String kogodotyczyudar = request.getParameter("kogodotyczyudar");
        String jakienawyki = request.getParameter("jakienawyki");
        String objawy = request.getParameter("objawy");
        String podejrzenie = request.getParameter("podejrzenie");
        String jakiebadanie = request.getParameter("jakiebadanie");
        String objawypoudarowe = request.getParameter("objawypoudarowe");
        String dysfagia = request.getParameter("dysfagia");
        String jakienawykizywieniowe = request.getParameter("jakienawykizywieniowe");
        String jakzapobiegac = request.getParameter("jakzapobiegac");
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazadanych?useSSL=false", "root","bazadanych");
	    System.out.println("POLACZONO");
            
            Statement s = c.createStatement();

            
            ResultSet rs= s.executeQuery("select max(id_ank) from ankieta");
            while (rs.next()) {
                int id_ank=rs.getInt(1);
                id_ank=id_ank+1;
                
            System.out.println("to jest" + id_ank);
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+plec+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+wiek+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+miejsce_zam+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+wzrost+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+waga+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+cisnienies+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+cisnienier+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+nadcisnienie+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+czynnik+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+alkohol+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+udar+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+ktoraprzyczynasmierci+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+kogodotyczyudar+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+jakienawyki+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+objawy+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+podejrzenie+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+jakiebadanie+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+objawypoudarowe+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+dysfagia+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+jakienawykizywieniowe+"')");
            s.executeUpdate("insert into ankieta (id_ank,id_odp) values('"+id_ank+"', '"+jakzapobiegac+"')");

            System.out.println("DODANO");
          }
       
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(("index2.html"));
    }
    
}

