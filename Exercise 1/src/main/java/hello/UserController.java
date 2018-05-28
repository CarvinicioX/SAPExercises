package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	//private IUserService service;

	@RequestMapping(method = RequestMethod.GET)
	   @ResponseBody
	   public List<User> findAll() {
	       return service.findAll();
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public User findOne(@PathVariable("id") Long id) {
	       return RestPreconditions.checkFound( service.findOne( id ));
	   }
	 
	   @RequestMapping(method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public Long create(@RequestBody User resource) {
	       Preconditions.checkNotNull(resource);
	       return service.create(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
	       Preconditions.checkNotNull(resource);
	       RestPreconditions.checkNotNull(service.getById( resource.getId()));
	       service.update(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       service.deleteById(id);
	   }
}