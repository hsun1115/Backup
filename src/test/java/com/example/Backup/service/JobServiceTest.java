package com.example.Backup.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.Backup.dao.JobDao;
import com.example.Backup.entities.jobs.Job;
import com.example.Backup.service.job.JobService;
import com.example.Backup.util.JobStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class JobServiceTest {
    @Mock
    private JobDao jobRepository;
    @InjectMocks
    private JobService jobService;


    @Test
    public void testInsert() {
        Job job = new Job();
        Long id = 1234L;
        job.setJob_id(id);
        job.setJob_info("this is a new job");
        job.setPoster_id(1000L);
        job.setStatus(JobStatus.DEFINED);
        PowerMockito.when(jobRepository.insert(job)).thenReturn(1);
        Job mock = jobService.postJob(job);
        Assert.assertEquals(mock.getJob_info(), job.getJob_info());
    }

    @Test
    public void testSelectById() {
        Job job1 = new Job();
        job1.setJob_id(1L);
        PowerMockito.when(jobRepository.selectById(Mockito.anyObject())).thenReturn(job1);
        Job mock = jobService.getById(1L);
        Assert.assertEquals(job1, mock);
    }

    @Test
    public void testSelectAll() {
        Job job1 = new Job();
        Job job2 = new Job();
        job1.setJob_id(1L);
        job2.setJob_id(2l);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        PowerMockito.when(jobRepository.selectList(Mockito.anyObject())).thenReturn(list);
        List<Job> mock = jobService.getAllJobs();
        Assert.assertEquals(2, mock.size());
    }

    @Test
    public void testUpdateJob() {
        Job job = new Job();
        job.setStatus(JobStatus.BIDING);
        job.setJob_id(123L);
        job.setJob_info("update");
        UpdateWrapper<Job> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("job_id", 123L);
        PowerMockito.when(jobRepository.selectById(Mockito.anyObject())).thenReturn(job);
        PowerMockito.when(jobRepository.update(Mockito.any(), Mockito.any())).thenReturn(1);
        int num = jobService.updateJobById(123L, job);
        Assert.assertEquals(1, num);
    }
}
