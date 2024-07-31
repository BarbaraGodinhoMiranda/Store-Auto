package com.example.demo;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class autocontroller {
	
	ArrayList<auto> lista = new ArrayList<>();
	
	 
	 
	 @GetMapping("/Auto")
	    public String getAutomobile(Model model) {
		 
		 	   		    	
	        return "automobile";
	              
	       
}
	 @GetMapping("/form")
	    public String getForm(Model model) {
	    	
		 auto a1 = new auto();
	    	a1.setModello("Cayenne");
	    	a1.setMarca("Porche");
	    	a1.setTipologia("SUV");
	    	a1.setPrezzo(150000);
	    	a1.setImg("Cayenne.jpg");
	    	System.out.println(a1.getImg());
	    	
	    	
	    	model.addAttribute("auto", a1);
	    	lista.add(a1);
		 
	        auto a2 = new auto();
	    	a2.setModello("F-Pace");
	    	a2.setMarca("Jaguar");
	    	a2.setTipologia("SUV");
	    	a2.setPrezzo(100000);
	    	a2.setImg("F-Pace.jpg");
	    	System.out.println(a2.getImg());
	    	
	    	
	    	model.addAttribute("auto", a2);
	    	lista.add(a2);
	    	
	    	auto a3 = new auto();
	    	a3.setModello("Defender");
	    	a3.setMarca("Landrover");
	    	a3.setTipologia("SUV");
	    	a3.setPrezzo(65000);
	    	a3.setImg("Defender.jpg");
	    	System.out.println(a3.getImg());
	    	
	    	
	    	model.addAttribute("auto", a3);
	    	lista.add(a3);

            auto a4 = new auto();
            a4.setModello("Wrangler");
 	    	a4.setMarca("Jeep");
 	    	a4.setTipologia("SUV");
 	    	a4.setPrezzo(75000);
 	    	a4.setImg("Wrangler.jpg");
 	    	System.out.println(a4.getImg());
 	    	
 	    	
 	    	model.addAttribute("auto", a4);
            lista.add(a4);

		 
	        return "form";
	       }
	 
	 @PostMapping("/submit") 
 		public String getDate(@RequestParam("modello") String modello,
             @RequestParam("marca") String marca, @RequestParam("tipologia") String tipologia,
             @RequestParam("prezzo") String prezzo, @RequestParam("img") String img,  Model model) 	{
 	
 	
 	
 	
 	
 	model.addAttribute("modello", modello);
 	model.addAttribute("marca", marca);
 	model.addAttribute("tipologia", tipologia);
 	Double prezzo1 = Double.parseDouble(prezzo);
 	model.addAttribute("img", img);
 	
 	
 	
 	auto a1 = new auto();
 	a1.setModello(modello);
 	a1.setMarca(marca);
 	a1.setTipologia(tipologia);
 	a1.setPrezzo(prezzo1);
 	a1.setImg(img);
 	
 	
 	
 	lista.add(a1);
 	
			
 	
 	return "post";
}
	 @GetMapping("/show")
	    public String getLista(Model model) {
	    	model.addAttribute("lista", lista);
	        return "automobile";
	       }
	 
	 @PostMapping("/process")
	    public String getProcess(Model model, @RequestParam("qnts")  String [] pezzi) {
	    	ArrayList <prodottoAc> listaP = new ArrayList<>();
	    	ArrayList <auto> prodottiAc = new ArrayList<>();
	    	ArrayList <Integer> num = new ArrayList<>();
	    	for (int i = 0; i < pezzi.length; i++) {
	    		
	    		if (!pezzi[i].equals("0")) {
	    			
	    			int pezzo = Integer.parseInt(pezzi[i]);
	    			num.add(pezzo);
	    			prodottiAc.add(lista.get(i));
	    			prodottoAc p1 = new prodottoAc();
	    			p1.setModello(lista.get(i).getModello());
	    			p1.setPezzi(pezzo);
	    			p1.setPrezzo(lista.get(i).getPrezzo());
	    			listaP.add(p1);
	    		}
	    		
	    		
	    	}
	    	
	    	System.out.println("Hai acquistato ");
	    	for (int i = 0; i < prodottiAc.size(); i++) {
	    		System.out.println(prodottiAc.get(i).getModello());
	    		System.out.println("In  tot: " + num.get(i) + " pezzi");
	    	}
	    	
	    	model.addAttribute("listaP", listaP);
	    	
	    	
	    
	    	 
	    	 return "buy";
	    }
	 // implementare la somma 
	 
	 
	 
}
