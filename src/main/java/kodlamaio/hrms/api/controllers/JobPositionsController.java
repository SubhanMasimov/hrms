package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}
	
	@GetMapping("/getalldata")
	List<JobPosition> getAllData() {
		return jobPositionService.getAll().getData();
	}

	@GetMapping("/getbyid")
	DataResult<JobPosition> getById(@RequestParam("id") int id) {
		return jobPositionService.getById(id);
	}
	
}
