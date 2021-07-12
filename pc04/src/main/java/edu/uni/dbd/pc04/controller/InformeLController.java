package edu.uni.dbd.pc04.controller;

import edu.uni.dbd.pc04.bean.ActividadLResponse;
import edu.uni.dbd.pc04.bean.ActividadResponse;
import edu.uni.dbd.pc04.bean.InformeLResponse;
import edu.uni.dbd.pc04.bean.InformeResponse;
import edu.uni.dbd.pc04.request.ActividadRequest;
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
public class InformeLController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/listainforme")
    public ArrayList<InformeLResponse> getInformes(@RequestBody ActividadRequest p)throws Exception{
        ArrayList<InformeLResponse> inf =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT CODIGO, NOMBRE, TO_CHAR(FECHA,'DD/MM/YYYY') FROM INFORME WHERE CODIGO_ACT = ? AND CODIGO_TIPO_ACT=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getCodigo());
        pst.setString(2,p.getCodigo_tipo());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            inf.add(new InformeLResponse(rs.getString(1),rs.getString(2),rs.getString(3)));
        }
        rs.close();
        pst.close();
        conn.close();
        return inf;
    }
    @PostMapping("/obtenerInforme")
    public InformeResponse getInforme(@RequestBody IdRequest p)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT I.CODIGO, TO_CHAR(I.FECHA,'DD/MM/YYYY') , I.NOMBRE,I.URL_PDF FROM INFORME I WHERE I.CODIGO= ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, p.getId());

        ResultSet rs = pst.executeQuery();
        rs.next();
        InformeResponse inf = new InformeResponse(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4));
        rs.close();
        pst.close();
        conn.close();
        return inf;
    }

}
