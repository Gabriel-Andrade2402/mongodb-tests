package gabriel.dev.springmongo.MongoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabriel.dev.springmongo.MongoApp.entities.UserDocument;
import gabriel.dev.springmongo.MongoApp.services.UserService;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserService userServ;
	
	@GetMapping
	public ResponseEntity<List<UserDocument>> findAll(){
		return ResponseEntity.ok().body(userServ.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UserDocument user){
		userServ.save(user.getNome(),user.getIdade());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/count")
	public ResponseEntity<Long> count(){
		return ResponseEntity.ok().body(userServ.count());
	}
	
	@GetMapping(value="/by")
	public ResponseEntity<UserDocument> findById(@RequestParam String id){
		return ResponseEntity.ok().body(userServ.findById(id));
	}
	
	@DeleteMapping(value="/by")
	public void deleteById(@RequestParam String id){
		userServ.delete(id);
	}
}
