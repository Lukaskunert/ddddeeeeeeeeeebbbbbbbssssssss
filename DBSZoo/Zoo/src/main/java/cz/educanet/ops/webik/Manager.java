package cz.educanet.ops.webik;

import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;

@ApplicationScoped
    public class Manager {
    static ArrayList<Zvirata> zvirata = new ArrayList<>();

    public ArrayList<Zvirata> getZvirata(){
        return zvirata;
    }
}
