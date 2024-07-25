package com.sist.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sist.db.service.DeptService;
import com.sist.db.vo.DeptVO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DeptController {
    
    @Autowired
    private DeptService d_Service;
    
    
    @RequestMapping(value="dept", method=RequestMethod.GET)
    public ModelAndView dept() {
        ModelAndView mv = new ModelAndView();
        
        DeptVO[] d_ar = d_Service.getAll();

        mv.addObject("d_ar", d_ar);
        mv.setViewName("dept");
        
        return mv;
    }
    


}
