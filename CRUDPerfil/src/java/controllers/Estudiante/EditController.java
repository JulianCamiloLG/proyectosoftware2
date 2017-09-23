/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Estudiante;

import Models.Conexion;
import Models.Estudiante;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JulianCamilo
 */
public class EditController {
    
        private JdbcTemplate jdbcTemp;

    public EditController() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String codigo = request.getParameter("codigo");
        Estudiante est = this.selectEst(codigo);
        mav.setViewName("Estudiantes/editar");
        Estudiante newEst = new Estudiante(est.getCodigo(), est.getNombre(), est.getApellido(), est.getEdad(), est.getCorreo());
        mav.addObject("estudiante", newEst);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("Estudiante") Estudiante e,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        String codigo = request.getParameter("codigo");
        this.jdbcTemp.update(
                "update estudiantes "
                + "set nombre=?,"
                + "apellido=?,"
                + "edad=?,"
                + "correo_electronico=?,"
                + "where "
                + "codigo=? ",
                e.getNombre(), e.getApellido(), e.getEdad(), e.getCorreo(), codigo);
        return new ModelAndView("redirect:/");
    }

    public Estudiante selectEst(String codigo) {
        final Estudiante est = new Estudiante();
        String query = "SELECT * FROM estudiantes WHERE codigo='" + codigo + "'";
        return (Estudiante) jdbcTemp.query(
                query, new ResultSetExtractor<Estudiante>() {
            public Estudiante extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    est.setCodigo(rs.getString("codigo"));
                    est.setNombre(rs.getString("nombre"));
                    est.setApellido(rs.getString("apellido"));
                    est.setEdad(rs.getString("edad"));
                    est.setCorreo(rs.getString("correo"));
                }
                return est;
            }
        }
        );
    }
}

