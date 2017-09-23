/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Estudiante;

import Models.Conexion;
import Models.Estudiante;
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
 * @author Juan
 */

@Controller
@RequestMapping("add.htm")
public class AddController {
    private JdbcTemplate jdbcTemp;
    
    public AddController() {
        this.jdbcTemp = new JdbcTemplate(new Conexion().conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Estudiante/add");
        mav.addObject("estudiante",new Estudiante());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("estudiante") Estudiante e,
                BindingResult result,
                SessionStatus status
    ) {
        this.jdbcTemp.update("INSERT INTO estudiantes(codigo, nombre, apellido, email, password, programa) "
                + "VALUES (?,?,?,?,?,?)", e.getCodigo(), e.getNombre(), e.getApellido(), e.getEmail(), e.getPassword(), e.getPrograma());
        return new ModelAndView("redirect:/");
    }
}
