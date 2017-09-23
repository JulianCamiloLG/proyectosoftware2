/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Estudiante;

import Models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JulianCamilo
 */
public class DeleteController {
    private JdbcTemplate jdbcTemp;
    
    public DeleteController() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping("borrar.htm")
    public ModelAndView delete(HttpServletRequest request) {
        String codigo = request.getParameter("codigo");
        this.jdbcTemp.update(
                    "delete from estudiantes "
                + "where "
                + "codigo=? ",
        codigo);
        return new ModelAndView("redirect:/");
    }
}
