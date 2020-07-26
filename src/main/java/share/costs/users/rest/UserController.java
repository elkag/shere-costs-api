package share.costs.users.rest;

import share.costs.users.model.UserModel;
import share.costs.users.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public void registerUser(@RequestBody final UserModel user) {
      userService.registerUser(user);
  }

  @PostMapping("/login")
  public LoginResponse loginUser(@RequestBody final LoginRequest request) {

    return userService.loginUser(request.getUsername(), request.getPassword());
  }

  @PostMapping("/check-username")
  public UsernameCheckResponse checkUsername(@RequestBody final UsernameCheckRequest request) {
    return userService.checkUsername(request.getUsername());
  }
}
