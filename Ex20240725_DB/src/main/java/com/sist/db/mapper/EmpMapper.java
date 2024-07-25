package com.sist.db.mapper;

import java.util.List;

import com.sist.db.vo.EmpVO;

public interface EmpMapper {
    // 추상메서드만 정의한다. 이때 기준은
    // emp.xml의 id들과 동일한 이름의 추상메서드를 정의한다.

    List<EmpVO> all();

}
