package com.example.Backup.service.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.Backup.dao.JobDao;
import com.example.Backup.entities.jobs.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService{
    //private static final Logger logger = LogManager.getLogger(JobServiceImpl.class);
    @Autowired
    private JobDao jobDao;

    public Job postJob(Job job) {
        jobDao.insert(job);
        //logger.debug("job added" + job);
        return job;
    }

    public List<Job> getAllJobs() {
        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("job_id", "job_info", "poster_id", "status");
        List<Job> list = jobDao.selectList(queryWrapper);
        return list;
    }

    public Job getById(Long id) {
        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_id", id);
        Job res = jobDao.selectOne(queryWrapper);
        if (null == res) {
            //logger.debug("no data found");
        }
        return res;
    }

    public Job updateJobById(Long id, Job job) {
        if (null == id) {
            throw new NullPointerException();
        } else {
            UpdateWrapper<Job> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("job_id", id);
            Job newJ = new Job();
            newJ.setJob_info(job.getJob_info());
//            newJ.setDDL(job.getDDL());
            newJ.setStatus(job.getStatus());
            newJ.setPoster_id(job.getPoster_id());
            jobDao.update(newJ,updateWrapper);
        }
        return job;
    }

    public void updateJobStatus(Long id, String status) {
        if (null == id) {
            throw new NullPointerException();
        }
        UpdateWrapper<Job> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("job_id", id);
        Job newJob = new Job();
        newJob.setStatus(status);
        jobDao.update(newJob, updateWrapper);
    }

    public void deleteJobById(Long id) {
        QueryWrapper<Job> qw = new QueryWrapper<>();
        qw.eq("job_id", id);
        jobDao.delete(qw);
    }

    public Long count() {
        QueryWrapper<Job> qw = new QueryWrapper<>();
        qw.select("job_id");
        Long count = jobDao.selectCount(qw);
        return count;
    }
}
