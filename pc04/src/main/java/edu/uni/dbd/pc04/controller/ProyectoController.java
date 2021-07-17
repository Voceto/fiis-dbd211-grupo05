package edu.uni.dbd.pc04.controller;

import edu.uni.dbd.pc04.bean.*;
import edu.uni.dbd.pc04.request.ActividadRequest;
import edu.uni.dbd.pc04.request.IdFechaRequest;
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
public class ProyectoController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/obtenerUltimoProyecto")
    public ProyectoUltResponse getUltimoProyecto(@RequestBody IdRequest i)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT P.NOMBRE, P.CODIGO, P.ESTADO, CONCAT(E.PRIM_NOMBRE,' ', E.PRIM_APELLIDO,' ',E.SEG_APELLIDO)," +
                "P.FECHA_INICIO_REAL," +
                "P.FECHA_ENTREGA_PROGRAM," +
                "COALESCE(TO_CHAR(P.FECHA_ENTREGA_REAL,'DD/MM/YYYY'),'Proyecto " +
                "por terminar') " +
                "FROM PROYECTO P," +
                "STAFF_PROYECTO S,EMPLEADO E,USUARIO U,REPEMPRESA R  " +
                "WHERE S.CODIGO_PROY = P.CODIGO AND E.DNI = S.DNI_EMPLEADO AND " +
                "P.FECHA_INICIO_REAL = (SELECT MAX(FECHA_INICIO_REAL) " +
                "FROM PROYECTO " +
                "WHERE DNI_REPCLIENTE = P.dni_repcliente) " +
                "AND S.ROL_PROY = 'Jefe' AND P.dni_repcliente=R.DNI AND R.USERNAME=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,i.getId());
        ResultSet rs = pst.executeQuery();
        ProyectoUltResponse proy;
        if(rs.next()){
            proy = new ProyectoUltResponse(rs.getString(1),rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getString(5),rs.getString(6),
                    rs.getString(7));
        }else{
            proy = null;
        }
        rs.close();
        pst.close();
        conn.close();
        return proy;

    }
    @PostMapping("/listaProyectos")
    public ArrayList<ProyectoLResponse> getProyectos(@RequestBody IdRequest p)throws Exception{
        ArrayList<ProyectoLResponse> a =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT P.CODIGO, P.NOMBRE,COALESCE(TO_CHAR(P.FECHA_INICIO_REAL,'DD/MM/YYYY'),'No iniciado'), P.ESTADO " +
                "FROM PROYECTO P " +
                "JOIN REPEMPRESA R ON R.DNI = P.DNI_REPCLIENTE " +
                "WHERE R.USERNAME = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getId());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new ProyectoLResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
    @PostMapping("/filtroProyectos")
    public ArrayList<ProyectoLResponse> filtrarProyectos(@RequestBody IdFechaRequest p)throws Exception{
        ArrayList<ProyectoLResponse> a =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT P.CODIGO, P.NOMBRE,COALESCE(TO_CHAR(P.FECHA_INICIO_REAL,'DD/MM/YYYY'),'No iniciado'), P.ESTADO " +
                "FROM PROYECTO P " +
                "JOIN REPEMPRESA R ON R.DNI = P.DNI_REPCLIENTE " +
                "WHERE R.USERNAME = ? AND P.FECHA_INICIO_REAL BETWEEN TO_DATE(?,'YYYY-MM-DD')AND TO_DATE(?,'YYYY-MM-DD')";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getId());
        pst.setString(2,p.getFmin());
        pst.setString(3,p.getFmax());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new ProyectoLResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
    @PostMapping("/obtenerProyecto")
    public ProyectoResponse getActividad(@RequestBody IdRequest id)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT P.NOMBRE,P.CODIGO,P.ESTADO,TO_CHAR(P.FECHA_INICIO_PROGRAM,'DD/MM/YYYY'),COALESCE(TO_CHAR(P.FECHA_INICIO_REAL,'DD/MM/YYYY'),'No iniciado'),TO_CHAR(P.FECHA_ENTREGA_PROGRAM,'DD/MM/YYYY'), COALESCE(TO_CHAR(P.FECHA_ENTREGA_REAL,'DD/MM/YYYY'),'No entregado'), E.PRIM_APELLIDO||' '||E.SEG_APELLIDO||' '||E.PRIM_NOMBRE "+
        "FROM PROYECTO P , EMPLEADO E, STAFF_PROYECTO S "+
        "WHERE P.CODIGO = ? "+
        "AND S.CODIGO_PROY = P.CODIGO "+
        "AND E.DNI = S.DNI_EMPLEADO "+
        "AND S.ROL_PROY = 'Jefe'";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,id.getId());
        ResultSet rs = pst.executeQuery();
        rs.next();
        ProyectoResponse proy = new ProyectoResponse(rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                rs.getString(8));
        rs.close();
        pst.close();
        conn.close();
        return proy;
    }

}
