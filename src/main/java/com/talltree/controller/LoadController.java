@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionException {

        Map<String, JobParameter> maps = new Hashmap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters();
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution" + jobExecution.getStatus());

        System.out.println("Batch is running...");
        while(jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }

}