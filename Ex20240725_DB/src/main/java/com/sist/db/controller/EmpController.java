package com.sist.db.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sist.db.service.EmpService;
import com.sist.db.vo.EmpVO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmpController {
    @Autowired
    private EmpService e_Service;

    @RequestMapping(value="/emp", method=RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView mv = new ModelAndView();
        EmpVO[] e_ar = e_Service.getAll();

        mv.addObject("e_ar", e_ar);
        mv.setViewName("all");

        return mv;
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView subAll(@RequestParam String begin,@RequestParam  String end) {
        ModelAndView mv = new ModelAndView();
        Map<String, String> e_map = new HashMap<>();
        e_map.put("begin", begin);
        e_map.put("end", end);

        EmpVO[] e_ar = e_Service.getSubAll(e_map);

        mv.addObject("e_ar", e_ar);
        mv.setViewName("list");

        return mv;
    }



}
