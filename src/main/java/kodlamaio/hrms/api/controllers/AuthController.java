package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import kodlamaio.hrms.entities.dtos.UserLoginDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}


	@PostMapping("login")
	Result login(@RequestBody UserLoginDto dto) {
		return authService.login(dto);
	}
	
	@PostMapping("registerCandidate")
	Result registerCandidate (@RequestBody CandidateRegisterDto dto) {
		return authService.registerCandidate(dto);
	}
	
	@PostMapping("registerCompany")
	Result registerCompany (@RequestBody CompanyRegisterDto dto) {
		return authService.registerCompany(dto);
	}
}
