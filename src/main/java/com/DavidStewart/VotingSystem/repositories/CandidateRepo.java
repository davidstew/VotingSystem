package com.DavidStewart.VotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DavidStewart.VotingSystem.entity.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer>{
	public Candidate findById(long id);

}
