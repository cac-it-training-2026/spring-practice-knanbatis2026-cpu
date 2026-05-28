package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {
	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	public String guessnumber(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		session.setAttribute("hitNumber", hitNumber);
		return "/practice04/02/numguess_start";
	}

	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	public String input() {
		return "practice04/02/numguess_input";
	}

	@RequestMapping(path = "/numguess/judge", method = RequestMethod.GET)
	public String judge(HttpSession session, Integer inputNum) {
		Integer num = (Integer) session.getAttribute("hitNumber");
		if (num.equals(inputNum)) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}

	@RequestMapping(path = "numguess/hit", method = RequestMethod.GET)
	public String hit(Model model, HttpSession session) {
		Integer answer = (Integer) session.getAttribute("hitNumber");
		model.addAttribute("resultText", "当たりです！正解は" + answer + "でした。");
		session.removeAttribute("hitNumber");
		return "practice04/02/numguess_end";
	}
}
