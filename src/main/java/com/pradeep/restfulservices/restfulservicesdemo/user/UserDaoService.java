package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

		private static List<User> users = new ArrayList<>();
		
		
		static {
			users.add(new User(1, "Adam", new Date()));
			users.add(new User(2, "Eve", new Date()));
			users.add(new User(3, "Steve", new Date()));
		}
		
		public List<User> findAll()
		{
			return users;
		}
		
		public User addUser(User user)
		{
			if(user.getId() == null)
			{
				user.setId(users.size()+1);
			}
			users.add(user);
			return user;
		}
		
		public User findUser(int id)
		{
			for(User user: users)
			{
				if(user.getId() == id)
					return user;
			}
			
			throw new UserNotFoundException("Requested Id: " + id + " not found");
			
		}

		public User save(User user) {
			
			return addUser(user);
			
		}
		
}
