package br.com.wellington.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wellington.data.vo.CardVO;
import br.com.wellington.service.CardService;

@RestController
@RequestMapping("/api/carta")
public class CardController {
	
	@Autowired
	private CardService cardServices;
	

	@PostMapping(value="create", produces = {"application/json"}, 
			consumes = {"application/json"})
	public CardVO create(@RequestBody CardVO card) {
		
		return cardServices.createCard(card);
	}
	
	@GetMapping(value="/{id}", produces = {"application/json"})
	public CardVO findById(@PathVariable("id" ) Long id) {
		
		CardVO cardVO = cardServices.findById(id);
		
		return cardVO;
	}
	
	@GetMapping(value="findByName/", produces = {"application/json"})
	public List<CardVO> findByName(@RequestParam(value="nome") String name) {
		
		return cardServices.findByName(name);
	}
	
	@GetMapping(value="findByType/", produces = {"application/json"})
	public List<CardVO> findByType(@RequestParam(value="tipo") String tipo) {
		
		return cardServices.findByType(tipo);
	}
	
	@GetMapping(value="findByClass/", produces = {"application/json"})
	public List<CardVO> findByClass(@RequestParam(value="classe") String classCard) {
		
		return cardServices.findByClass(classCard);
	}
	
	@GetMapping(produces = {"application/json"})
	public List<CardVO> findAll() {
		
		return cardServices.listAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCard(@PathVariable("id") Long id) {
		
		cardServices.deleteCard(id);
		return ResponseEntity.ok().build();
	}
}
