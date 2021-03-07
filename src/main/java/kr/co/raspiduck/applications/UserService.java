package kr.co.raspiduck.applications;

import kr.co.raspiduck.domain.User;
import kr.co.raspiduck.domain.UserRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User registerUser(User user) {

    User registerUser = User.builder().email(user.getEmail()).password(user.getPassword()).build();
    return userRepository.save(registerUser);
  }

}
