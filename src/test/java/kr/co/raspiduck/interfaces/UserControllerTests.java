package kr.co.raspiduck.interfaces;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.co.raspiduck.applications.UserService;
import kr.co.raspiduck.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTests {

  @Autowired
  private MockMvc mvc;
  
  @MockBean
  private UserService userService;


  @Test
  public void signUp() throws Exception {

    mvc.perform(MockMvcRequestBuilders.post("/signup")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"email\":\"leo\", \"password\":\"1234\"}"))
        .andExpect(status().isCreated())
        .andExpect(content().string("{}"));

    verify(userService).registerUser(any(User.class));

  }

}