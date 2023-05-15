package com.example.demo.emp.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	
	@Autowired
	EmpMapper emp;
	
//	@GetMapping("/")
//	@ResponseBody
//	public String main() {
//		return "hello";
//	}
//	
	
	//사원 전체 조회
	@GetMapping("/getEmpList")
	public String getEmpList(Model model){
		model.addAttribute("empList", emp.selectEmpAllList()  );
		
		List<EmpVO> vo = new ArrayList<EmpVO>();
		for(int i=0;i<10;i++) {
			
			EmpVO exp = new EmpVO();	
			exp.setB("i");
			vo.add(i, exp);
		}
		emp.insertTest(vo);
		return "empList";
	}
	
		
	
	
}
