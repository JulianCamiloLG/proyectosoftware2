/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
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

    @Controller
    @RequestMapping("agregar.htm")
public class AgregarSugerencias {

    private JdbcTemplate jdbcTemp;
    
    public AgregarSugerencias() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Sugerencia/agregar");
        mav.addObject("sugerencia",new Sugerencia());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("sugerencia") Sugerencia s,
                BindingResult result,
                SessionStatus status
    ) {
        this.jdbcTemp.update("INSERT INTO sugerencias(identificadorSugerencia,nombreSugerencia, descripcionSugerencia)"
                + "VALUES (?,?,?)",s.getIdentificador(), s.getNombreSugerencia(), s.getDescripcionSugerencia());
        return new ModelAndView("redirect:/");
    }
}
