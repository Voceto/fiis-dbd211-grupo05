package edu.uni.dbd.pc04.controller;

import edu.uni.dbd.pc04.bean.ActividadLResponse;
import edu.uni.dbd.pc04.bean.ActividadResponse;
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
public class ActividadLController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/listaActividades")
    public ArrayList<ActividadLResponse> getActividades(@RequestBody IdRequest p)throws Exception{
        ArrayList<ActividadLResponse> a =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT A.CODIGO,A.CODIGO_TIPO, T.NOMBRE , COALESCE(TO_CHAR(A.FECHA_INICIO_REAL,'DD/MM/YYYY'),'NO INICIADO'), A.ESTADO," +
                "(SELECT COUNT(*) FROM OBSERVACION O,INFORME I WHERE  O.ESTADO <> 'FINALIZADO' AND I.CODIGO = O.CODIGO_INF AND I.CODIGO_ACT = A.CODIGO AND I.CODIGO_TIPO_ACT=A.CODIGO_TIPO)" +
                "FROM ACTIVIDAD A, TIPOACTIVIDAD T " +
                "WHERE A.CODIGO_TIPO = T.CODIGO " +
                "AND A.CODIGO_PROY = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getId());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new ActividadLResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
    @PostMapping("/filtrarActividades")
    public ArrayList<ActividadLResponse> filtrarActividades(@RequestBody IdFechaRequest p)throws Exception{
        ArrayList<ActividadLResponse> a =new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT A.CODIGO,A.CODIGO_TIPO, T.NOMBRE , \n" +
                "COALESCE(TO_CHAR(A.FECHA_INICIO_REAL,'DD/MM/YYYY'),'NO INICIADO'), " +
                "A.ESTADO,(SELECT COUNT(*) FROM OBSERVACION O,INFORME I WHERE O.ESTADO <> 'FINALIZADO' " +
                "AND I.CODIGO = O.CODIGO_INF AND I.CODIGO_ACT = A.CODIGO AND I.CODIGO_TIPO_ACT=A.CODIGO_TIPO) " +
                "FROM ACTIVIDAD A, TIPOACTIVIDAD T WHERE A.CODIGO_TIPO = T.CODIGO " +
                "AND A.CODIGO_PROY = ? AND A.FECHA_INICIO_REAL BETWEEN TO_DATE(?,'YYYY-MM-DD') " +
                "AND TO_DATE(?,'YYYY-MM-DD')";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getId());
        pst.setString(2,p.getFmin());
        pst.setString(3,p.getFmax());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new ActividadLResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
    @PostMapping("/obtenerActividad")
    public ActividadResponse getActividad(@RequestBody  ActividadRequest a)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql= "SELECT A.CODIGO, TO_CHAR(A.FECHA_INICIO_PROGRAM,'DD/MM/YYYY'), TO_CHAR(A.FECHA_FIN_PROGRAM,'DD/MM/YYYY')," +
                "A.ESTADO, T.CODIGO,T.DESCRIPCION,T.NOMBRE,T.FREC_INSPECCION," +
                "T.DOC_REFERENCIA,T.TIPO_VERIFICACION,T.TIPO_INSPECCION," +
                "T.PUNTO_INSPECCION " +
                "FROM TIPOACTIVIDAD T ,ACTIVIDAD A " +
                "WHERE A.CODIGO = ? AND A.CODIGO_TIPO = ?" +
                "AND T.CODIGO = A.CODIGO_TIPO";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a.getCodigo());
        pst.setString(2,a.getCodigo_tipo());
        ResultSet rs = pst.executeQuery();
        rs.next();
        ActividadResponse act = new ActividadResponse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                rs.getString(10),rs.getString(11),rs.getString(12));
        rs.close();
        pst.close();
        conn.close();
        return act;
    }
}
