package kr.co.raspiduck.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import kr.co.raspiduck.applications.UserService;
import kr.co.raspiduck.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<?> signUp(
      @RequestBody User resource
  ) throws URISyntaxException {
    User user = new User();
    User registeredUser = userService.registerUser(user);

    String url = "/signup/1";
    return ResponseEntity.created(new URI(url)).body("{}");
  }


}
