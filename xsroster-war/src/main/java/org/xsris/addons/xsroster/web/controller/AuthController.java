package org.xsris.addons.xsroster.web.controller;

import java.util.Collections;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xsris.addons.xsroster.web.auth.UserInfo;
import org.xsris.addons.xsroster.web.view.JsonResult;

@Controller
@PermitAll()
public class AuthController {

	@RequestMapping(value = "/Access_Denied")
	public String accessDeniedPage(ModelMap model) {
		UserDetails user = getPrincipal();
		model.addAttribute("user", user != null ? user.getUsername() : "");
		return "accessDenied";
	}

	@ResponseBody
	@RequestMapping(value = "basicLogin")
	public JsonResult basicLogin() {
		return JsonResult.success();
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(ModelMap model) {
		UserDetails user = getPrincipal();
		if (user == null) {
			return "redirect:/login";
		}

		SimpleGrantedAuthority hasAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
		if (user.getAuthorities().contains(hasAdmin)) {
			return "redirect:/excel/editor";
		}
		return "redirect:/excel/viewer";
	}

	@RequestMapping(value = "/httpBasic")
	public String httpBasic(@RequestParam(name = "authorization", required = false) String authorization,
			ModelMap model) {
		if (StringUtils.isNoneEmpty(authorization)) {
			String b64 = new String(Base64.encodeBase64(authorization.getBytes()));
			model.addAttribute("authorization", b64);
			return "httpBasic";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/logout")
	public JsonResult logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/logoutPage")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		logout(request, response);
		return "redirect:/login?logout";
	}

	private UserDetails getPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		}

		Object principal = auth.getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return new UserInfo(principal.toString(), "", true, true, true, true,
					Collections.<GrantedAuthority> emptySet());
		}

	}
}
