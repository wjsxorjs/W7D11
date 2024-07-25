package com.sist.db.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.db.mapper.EmpMapper;
import com.sist.db.vo.EmpVO;

@Service
public class EmpService {
    
    @Autowired
    private EmpMapper e_mapper;

    public EmpVO[] getAll(){
        EmpVO[] e_ar = null;

        List<EmpVO> e_list = e_mapper.all();
        if(e_list != null && e_list.size()>0){
            e_ar = new EmpVO[e_list.size()];
            e_list.toArray(e_ar);
        }


        return e_ar;
    }
    
    public EmpVO[] getSubAll(Map<String, String> e_map){
        EmpVO[] e_ar = null;

        List<EmpVO> e_list = e_mapper.subAll(e_map);
        if(e_list != null && e_list.size()>0){
            e_ar = new EmpVO[e_list.size()];
            e_list.toArray(e_ar);
        }


        return e_ar;
    }

    public EmpVO[] search(Map<String,String> s_map){
        EmpVO[] e_ar = null;

        List<EmpVO> e_list = e_mapper.search(s_map);
        if(e_list != null && e_list.size()>0){
            e_ar = new EmpVO[e_list.size()];
            e_list.toArray(e_ar);
        }

        return e_ar;
    }

}
