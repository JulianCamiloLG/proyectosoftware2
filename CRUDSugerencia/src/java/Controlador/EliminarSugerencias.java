/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SALDARRIAGA VILLADA
 */
public class EliminarSugerencias {
     private JdbcTemplate jdbcTemp;
    
    public EliminarSugerencias() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping("eliminar.htm")
    public ModelAndView delete(HttpServletRequest request) {
        String identificador = request.getParameter("identificador");
        this.jdbcTemp.update(
                "delete from sugerencias "
                + "where "
                + "identificador=? ",
        identificador);
        return new ModelAndView("redirect:/");
    }
}
