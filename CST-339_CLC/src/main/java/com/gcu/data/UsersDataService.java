package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.repositories.UserRepository;
import com.gcu.repositories.UsersDataAccessInterface;

@Service
public class UsersDataService implements UsersDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository usersRepository;

    public UsersDataService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    public UserEntity findById(int userID) {
    	return null;
    }
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		
		try {
			Iterable<UserEntity> usersIterable = usersRepository.findAll();
			
			users = new ArrayList<UserEntity>();
			usersIterable.forEach(users::add);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public boolean create(UserEntity user) {
		try {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
			this.usersRepository.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserEntity findByUsername(String username) {
		
		return usersRepository.findByUsername(username);
	}

	@Override
	public boolean update(UserEntity user) {
        // Implementation for this method can be added later
		return false;
	}

	@Override
	public boolean delete(UserEntity user) {
        // Implementation for this method can be added later
		return false;
	}

	@Override
	public ProductEntity findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
