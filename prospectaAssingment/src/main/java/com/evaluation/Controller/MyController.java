package com.evaluation.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.evaluation.model.Data;
import com.evaluation.model.Entrity;
import com.evaluation.model.ResponseDTO;

@Controller
public class MyController {

	@Autowired
	private RestTemplate restTempltae;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResponseDTO>> getentriesHandler(@PathVariable("category") String category)
	{
		
        Data d=restTempltae.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entrity> elist=d.getEntries();
		List<ResponseDTO> rlist=elist.stream().filter((e)->{
			String str=e.getCategory();
			String[] st=str.split(" & ");
			for(String s:st) {
				if(s.equals(category)) {
					return true;
				}
			}
			return false;
		}).map(e->(new ResponseDTO(e.getApi(), e.getDescription()))).toList();
		return new ResponseEntity<List<ResponseDTO>>(rlist,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntiesHandler(@RequestBody Entrity entr)
	{
		
		Data d=restTempltae.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entrity> entries=d.getEntries();
		
		entries.add(entr);
		
		return new  ResponseEntity<String>("Save Entries",HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	
	
	
	
}
