package org.xsris.addons.xsroster.web.controller;

import java.util.Collections;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xsris.addons.xsroster.web.auth.UserInfo;

@Controller
@PermitAll()
public class AuthController {

	@RequestMapping(value = "/Access_Denied")
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal().getUsername());
		return "accessDenied";
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(ModelMap model) {
		UserDetails user = getPrincipal();

		SimpleGrantedAuthority hasAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
		if (user.getAuthorities().contains(hasAdmin)) {
			return "redirect:/excel/editor";
		}
		return "redirect:/excel/viewer";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private UserDetails getPrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return new UserInfo(principal.toString(), "", true, true, true, true,
					Collections.<GrantedAuthority> emptySet());
		}

	}
}
