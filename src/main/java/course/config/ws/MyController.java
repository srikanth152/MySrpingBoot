package course.config.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController	
@RequestMapping("/Emplyoee")
public class MyController {

//	@Autowired
//	private Employeeservices empService;

	/*@GetMapping("/Emplyoee/{empid}/Coures")
	public List<Coures> getAllCoursesofemp(@PathVariable int empid) {
		return empService.getAllCourses(empid);
	}*/
	
	@RequestMapping(value="/getEmp",method=RequestMethod.GET)
	public String getAllemp() {
		return "Hello";
	}
	
	/*@GetMapping("/Emplyoee/{empid}")
	public Employee getEmpdetailsofemp(@PathVariable int empid) {
		return empService.getEmpdetails(empid);
	}
	
	@GetMapping("/Emplyoee/{empid}/Coures/{id}")
	public Coures getcouresdetailsofemp(@PathVariable int empid,@PathVariable int id) {
		return empService.retrieveCourse(empid,id);
	}
	
	@GetMapping("/Emplyoee/{empid}/Coures/{id}/topics")
	public List<topics> gettopicsdetailsofemp(@PathVariable int empid,@PathVariable int id) {
		return empService.getAlltopics(empid,id);
	}*/
	

	/*@PostMapping("/Employee/{empid}/Coures")
	public ResponseEntity<Void> registerEmployeeForCourse(
			@PathVariable int studentId, @RequestBody Coures newCourse) {

		Coures course = empService.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getId()).toUri();

		return ResponseEntity.created(location).build();
	}*/
}
