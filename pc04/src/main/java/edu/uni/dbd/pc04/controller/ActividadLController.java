package edu.uni.dbd.pc04.controller;

import edu.uni.dbd.pc04.bean.ActividadLResponse;
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
public class ActividadLController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/listaActividades")
    public ArrayList<ActividadLResponse> getActividades(@RequestBody IdRequest p)throws Exception{
        ArrayList<ActividadLResponse> a =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT A.CODIGO, T.NOMBRE , TO_CHAR(A.FECHA_INICIO_REAL,'DD/MM/YYYY'), A.ESTADO, (SELECT COUNT(*) FROM OBSERVACION WHERE I.CODIGO = CODIGO_INF) FROM ACTIVIDAD A, TIPOACTIVIDAD T , INFORME I WHERE A.CODIGO_TIPO = T.CODIGO AND I.CODIGO_ACT = A.CODIGO AND A.CODIGO_PROY = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getId());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new ActividadLResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }

}
