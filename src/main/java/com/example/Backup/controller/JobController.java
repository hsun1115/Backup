package com.example.Backup.controller;

import com.example.Backup.entities.jobs.Job;
import com.example.Backup.service.job.JobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private static final Logger logger = LogManager.getLogger(JobController.class);

    @Autowired
    JobService jobService;

    @PostMapping("intuit/job/postjob/")
    public void postJob(@RequestBody Job job) {
        jobService.postJob(job);
        logger.debug("job added!");
    }

    @GetMapping("intuit/job/findjob/{id}")
    @ResponseBody
    public Job getByJobId(@PathVariable Long id) {
        Job j = jobService.getById(id);
        if (null == j) {
            logger.debug("no job founded");
        }
        return j;
    }

    @GetMapping("intuit/job/findalljob/")
    @ResponseBody
    public List<Job> getAllJobs() {
        List<Job> res = jobService.getAllJobs();
        return res;
    }

    @PostMapping("intuit/job/update/{id}")
    @ResponseBody
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJobById(id, job);
    }

    @DeleteMapping("intuit/job/delete/{id}")
    @ResponseBody
    public String deleteJobById(@PathVariable Long id) {
        jobService.deleteJobById(id);
        return "Delete Success!";
    }
}
