package gabriel.dev.springmongo.MongoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.dev.springmongo.MongoApp.entities.UserDocument;
import gabriel.dev.springmongo.MongoApp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public void save(String nome, Integer idade) {
        userRepo.save(new UserDocument(null,nome, idade));
    }
 
    public List<UserDocument> findAll() {
       return userRepo.findAll();
    }
 
    public long count() {
        return userRepo.count();
    }
 
    public UserDocument findById(String id) {
    	Optional<UserDocument> optional = userRepo.findById(id);
    	if(optional.isPresent()) {    		
    		return optional.get();
    	}else {
    		return null;
    	}
    }
 
    public void delete(String id) {
        userRepo.deleteById(id);
    }
}
