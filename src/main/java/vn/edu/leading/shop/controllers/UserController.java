package vn.edu.leading.shop.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.models.RoleModel;
//import vn.edu.leading.shop.repositories.BaseRepository;
import vn.edu.leading.shop.models.UserModel;
import vn.edu.leading.shop.repositories.RoleRepository;
import vn.edu.leading.shop.services.MailService;
import vn.edu.leading.shop.services.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController  {

    private final UserService userService;

    private final MailService mailService;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, MailService mailService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mailService = mailService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // lam mau de tao tai khoan

    @GetMapping("/user/new")
    public String list(UserModel userModel) {
        UserModel newUser = new UserModel();
        newUser.setUsername(userModel.getUsername());
        newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
        RoleModel roleModel = roleRepository.findByName("ROLE_USER");
        Set<RoleModel> roleModels = new HashSet<>();
        roleModels.add(roleModel);
        newUser.setRoleModels(roleModels);
        userService.save(newUser);
        return "thanh cong"+userModel.getUsername()+ " "+userModel.getPassword()+ " sau khi ma hoa "+passwordEncoder.encode(userModel.getPassword());
    }
    @PostMapping("/register")
    public String register(@Valid UserModel userModel) throws Exception {
     userService.register(userModel);
     mailService.sendMail(userModel);
        return "redirect:/login";
    }
    }
