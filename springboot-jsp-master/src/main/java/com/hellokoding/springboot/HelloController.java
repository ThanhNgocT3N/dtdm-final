package com.hellokoding.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellokoding.springboot.data.adapter;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/ic")
    public String ICSSE(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "test";
    }
    @RequestMapping("/edit")
    public String editor(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	adapter get = new adapter();
    	String noidung = get.layND();
        model.addAttribute("text",noidung);
    	//model.addAttribute("message", "hello");
        return "EDITOR";
    }
    @RequestMapping("/upload")
    @ResponseBody 
    public String uploadck(Model model,@RequestParam("noidung") String noidung) {
    	try{
    		System.out.println("aaaaaaaaaaaaa");
	    	adapter set = new adapter();
	    	set.CapNhat(noidung);
	    	return "thanhcong";
    	}
    	catch (Exception e) {
    		return "thatbai";
		}
    }
    @RequestMapping("/thatbai")
    public String thatbai() {
        return "fail";
    }
    @RequestMapping("/thanhcong")
    public String thanhcong(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	return "success";
    }
}
