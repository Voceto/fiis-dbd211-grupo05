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
    @PostMapping("/obtenerComentario")
    public ArrayList<ComentarioResponse> getComentario(@RequestBody IdRequest a) throws Exception{
        ArrayList<ComentarioResponse> com =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT C.USERNAME,C.CONTENIDO,CAST(C.ORDEN AS VARCHAR),TO_CHAR(C.FECHA,'DD/MM/YYYY'),TO_CHAR(C.FECHA,'HH24:MI') " +
                "FROM COMENTARIO C " +
                "JOIN OBSERVACION O ON O.ID = C.ID_OBSERVACION " +
                "JOIN INFORME I ON O.CODIGO_INF = I.CODIGO " +
                "WHERE O.ID = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,Integer.parseInt(a.getId()));
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            com.add(new ComentarioResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        }
        rs.close();
        pst.close();
        conn.close();
        return com;
    }
    @PostMapping("/responderComentario")
    public String responderComentario(@RequestBody ComentarioRequest a)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql1 = "SELECT COALESCE(MAX(ORDEN),0) FROM COMENTARIO WHERE ID_OBSERVACION = ?";
        PreparedStatement pst1 = conn.prepareStatement(sql1);
        pst1.setInt(1,Integer.parseInt(a.getId_observacion()));
        ResultSet rs = pst1.executeQuery();
        rs.next();
        String sql2 = "INSERT INTO COMENTARIO VALUES (?,NOW(),?,?,?)";
        PreparedStatement pst2 = conn.prepareStatement(sql2);
        int orden=rs.getInt(1)+1;
        pst2.setInt(4,Integer.parseInt(a.getId_observacion()));
        pst2.setString(3, a.getUsername());
        pst2.setString(2, a.getContenido());
        pst2.setInt(1, orden);
        pst2.executeUpdate();
        rs.close();
        pst1.close();
        pst2.close();
        conn.close();
        return String.valueOf(orden);
    }
}
