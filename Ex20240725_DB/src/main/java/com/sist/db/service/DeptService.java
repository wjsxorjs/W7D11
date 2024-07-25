package com.sist.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.db.mapper.DeptMapper;
import com.sist.db.vo.DeptVO;

@Service
public class DeptService {
    
    @Autowired
    private DeptMapper d_mapper;

    public DeptVO[] getAll(){
        DeptVO[] d_ar = null;

        List<DeptVO> d_list = d_mapper.all();

        if(d_list != null && d_list.size()>0){
            d_ar = new DeptVO[d_list.size()];

            d_list.toArray(d_ar);
        }

        return d_ar;
    }
}
