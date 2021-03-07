package kr.co.raspiduck.applications;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

import kr.co.raspiduck.domain.User;
import kr.co.raspiduck.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class UserServiceTests {

  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @BeforeEach
  public void setUp() {
    openMocks(this);
    this.userService = new UserService(userRepository);
  }

  @Test
  public void registerUser() {

    User mockUser = User.builder().email("test@test.com").build();
    given(userRepository.save(any(User.class))).willReturn(mockUser);

    String email = "test@test.com";
    String password = "1234";
    User user = User.builder().email(email).password(password).build();

    User registerUser = userService.registerUser(user);

    assertEquals(registerUser.getEmail(), email);

    verify(userRepository).save(any());

  }

}