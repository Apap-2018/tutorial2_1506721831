package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	@RequestMapping("/viral") //nentuin manggil apa di browser, viral mapping ke index, viral bakal manggil method dibawahnya
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge") //challenge manggil method challenge, mapping ke methodnya 
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
	return "challenge";
	}
	
	@RequestMapping("/generator") //routing di web
    public String generator(@RequestParam(value = "a",  required=false, defaultValue = "0") int a, @RequestParam(value = "b",  required=false, defaultValue = "0") int b, Model model) {
        String hasil = "hm";
        model.addAttribute("a", a);//buat m
        model.addAttribute("b", b);//nge pass data, b buat hm

        while(a > 1) {
            hasil = hasil + "m";
            a--;
        } while (b > 1) {
            hasil +=  " " + hasil;
            b--;
        }

        model.addAttribute("hasil", hasil);
        return "generator"; //return view generator.html
    }
}
