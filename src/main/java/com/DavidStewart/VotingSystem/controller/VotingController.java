package com.DavidStewart.VotingSystem.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DavidStewart.VotingSystem.entity.Candidate;
import com.DavidStewart.VotingSystem.entity.Citizen;
import com.DavidStewart.VotingSystem.repositories.CandidateRepo;
import com.DavidStewart.VotingSystem.repositories.CitizenRepo;

@Controller
public class VotingController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen", citizen);
		
		if (!citizen.getHasVoted()) {
			List<Candidate> candidates = candidateRepo.findAll(); 
			model.addAttribute("candidates", candidates);			
			return "/performVoted.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		if (!citizen.getHasVoted()) {
			citizen.setHasVoted(true);
		Candidate c = candidateRepo.findById((long) id);
		c.setNumberOfVotes(c.getNumberOfVotes() + 1);
		candidateRepo.save(c);
		citizenRepo.save(citizen);
		return "voted.html";
		}
		
		return "/alreadyVoted.html";
	}

}
