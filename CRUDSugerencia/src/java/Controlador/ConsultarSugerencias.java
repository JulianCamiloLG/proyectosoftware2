/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SALDARRIAGA VILLADA
 */
public class ConsultarSugerencias {
    
    private JdbcTemplate jdbcTemp;
    
    public ConsultarSugerencias() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping("list.htm")
    public ModelAndView home()
    {
        ModelAndView mav=new ModelAndView();
        String sql="select * from sugerencia";
        List sugerencias=this.jdbcTemp.queryForList(sql);
        mav.addObject("sugerencia",sugerencias);
        mav.setViewName("Sugerencia/list");
        return mav;
    }
}
