package gabriel.dev.springmongo.MongoApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gabriel.dev.springmongo.MongoApp.entities.UserDocument;

@Repository
public interface UserRepository extends MongoRepository<UserDocument,String>{

}
