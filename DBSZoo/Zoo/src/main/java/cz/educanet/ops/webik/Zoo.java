package cz.educanet.ops.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@Produces(MediaType.APPLICATION_JSON)
@Path("zoo")
public class Zoo {
    @Inject
    private Manager manager;
    @GET
    public Response getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/c3zoo", "root", ""
        );
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT Zvirata.id, Zvirata.jmeno, Druhy.nazev FROM Zvirata JOIN Druhy ON (Zvirata.druh = Druhy.id) LIMIT 10");

        while(result.next()){
            Zviratka zvire = new Zvire();
            String id = result.getString("id");
            zvire.setId(id);
            String jmeno = result.getString("jmeno");
            zvire.setJmeno(jmeno);
            String typ = result.getString("nazev");
            zvire.setTyp(typ);

        }
        connection.close();
        return Response.ok(manager.getZvire()).build();
    }
}
