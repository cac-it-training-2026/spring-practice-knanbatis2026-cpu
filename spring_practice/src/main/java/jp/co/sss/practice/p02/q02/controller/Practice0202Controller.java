package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {
	@RequestMapping(path = "/show/redirect_page")
	public String redirectLink() {
		return "practice02/02/redirect_link";
	}

	@RequestMapping(path = "/absolute")
	public String redirectGoogle() {
		return "redirect:https://www.google.co.jp";
	}

	@RequestMapping(path = "/relative")
	public String redirectResult() {
		return "redirect:/result";
	}

	@RequestMapping(path = "/result")
	public String result() {
		return "practice02/02/redirect_result";
	}
}
