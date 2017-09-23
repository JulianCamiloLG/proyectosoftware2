/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
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
 * @author SALDARRIAGA VILLADA
 */
public class EditarSugerencias {
    
private JdbcTemplate jdbcTemp;

    public EditarSugerencias() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String identificador = request.getParameter("identificador");
        Sugerencia sug = this.selectSug(identificador);
        mav.setViewName("Sugerencia/editar");
        Sugerencia newSug = new Sugerencia(sug.getIdentificador(), sug.getNombreSugerencia(), sug.getDescripcionSugerencia());
        mav.addObject("sugerencia", newSug);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("Sugerencia") Sugerencia s,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        String identificador = request.getParameter("identificador");
        this.jdbcTemp.update(
                "update estudiantes "
                + "set nombreSugerencia=?,"
                + "descripcionSugerencia=?,",
                s.getNombreSugerencia(),s.getDescripcionSugerencia(), identificador);
        return new ModelAndView("redirect:/");
    }

    public Sugerencia selectSug(String codigo) {
        final Sugerencia sug = new Sugerencia();
        String query = "SELECT * FROM sugerencia WHERE identificadorSugerencia='" + codigo + "'";
        return (Sugerencia) jdbcTemp.query(
                query, new ResultSetExtractor<Sugerencia>() {
            public Sugerencia extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    sug.setNombreSugerencia(rs.getString("nombreSugerencia"));
                    sug.setDescripcionSugerencia(rs.getString("descripcionSugerencia"));
                }
                return sug;
            }
        }
        );
    }
}
