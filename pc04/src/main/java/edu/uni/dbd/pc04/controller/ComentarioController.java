package edu.uni.dbd.pc04.controller;

import edu.uni.dbd.pc04.bean.ActividadLResponse;
import edu.uni.dbd.pc04.bean.ComentarioResponse;
import edu.uni.dbd.pc04.request.ComentarioRequest;
import edu.uni.dbd.pc04.request.IdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@RestController
public class ComentarioController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/ontenerComentario")
    public ArrayList<ComentarioResponse> getComentario(@RequestBody IdRequest a) throws Exception{
        ArrayList<ComentarioResponse> com =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT C.CONTENIDO " +
                "FROM COMENTARIO C " +
                "JOIN OBSERVACION O ON O.ID = C.ID_OBSERVACION " +
                "JOIN INFORME I ON O.CODIGO_INF = I.CODIGO " +
                "WHERE O.ID = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a.getId());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            com.add(new ComentarioResponse(rs.getString(1)));
        }
        rs.close();
        pst.close();
        conn.close();
        return com;
    }
    @PostMapping("/responderComentario")
    public String responderComentario(@RequestBody ComentarioRequest a)throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "INSERT INTO COMENTARIO VALUES (?,NOW(),?,?,?)";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setInt(4, a.getId_observacion());
        pst.setString(3, a.getUsername());
        pst.setString(2, a.getContenido());
        pst.setInt(1, a.getOrden());
        pst.executeUpdate();
        pst.close();
        connn.close();
        return "true";
    }
}
