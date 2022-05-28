package com.life.spring.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
//	@Autowired
//	AdminRepository repository;
//	
//	@PostMapping("/login")
//	@ResponseBody
//    public String loginUser(@Valid @RequestBody Admin admin) {
//       Iterable<Admin> admins=repository.findAll();
//
//        for (Admin ad : admins) {
//            if (ad.equals(admin)) {
//            	admin.setLoggedIn(true);
//                //repository.save(admin);
//                return "Login SUCCESSFULLY";
//            }
//        }
//
//        return "Login FAILURE";
//    }

	@RequestMapping("/welcome")
	public String displayAdmin() {

		return "jay mahakal";
	}

}
