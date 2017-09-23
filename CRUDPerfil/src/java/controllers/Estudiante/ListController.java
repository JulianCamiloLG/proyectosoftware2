/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Estudiante;

import Models.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JulianCamilo
 */
public class ListController {
    private JdbcTemplate jdbcTemp;
    
    public ListController() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping("consultartodos.htm")
    public ModelAndView home()
    {
        ModelAndView mav=new ModelAndView();
        String sql="select * from estudiantes";
        List estudiantes=this.jdbcTemp.queryForList(sql);
        mav.addObject("estudiantes",estudiantes);
        mav.setViewName("Estudiantes/list");
        return mav;
    }
}


