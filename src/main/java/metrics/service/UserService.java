package metrics.service;

import javax.transaction.Transactional;

import metrics.model.User;
import metrics.repo.jpa.UserRepo;
import metrics.repo.mybatis.ComplexQueryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ComplexQueryRepo cpxRepo;
	@Transactional
	public void create(User user) {
		userRepo.save(user);
	}

	@Transactional
	public User quertUser(String name,String pass) {
		return cpxRepo.queryUser(name, pass);
	}
	@Transactional
	public void update(User user) {
		User userDb = userRepo.findOne(user.getId());
		userDb.setName(user.getName());
		userDb.setPass(user.getPass());
		userDb.setId(user.getPower());
		userRepo.save(user);
	}
	@Transactional
	public User findOne(Integer id) {
		User user= userRepo.findOne(id);
		//System.out.println(theme.getAssociations());
		return user;
	}
}
