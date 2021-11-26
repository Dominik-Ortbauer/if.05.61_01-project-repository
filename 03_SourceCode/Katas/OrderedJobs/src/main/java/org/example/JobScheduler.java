package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JobScheduler
{
    private List<Job> mJobs = new LinkedList<>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if(!mJobs.contains(job)) {
            mJobs.add(job);
        }
    }

    public void sort() {
        
    }

    public String getList() {
        return mJobs;
    }

    public void registerJob(String dependentJob, String independentJob) {
        Job job = new Job(independentJob);
        if(!mJobs.contains(job)) {
            mJobs.add(job);
        }

        Job job2 = new Job(dependentJob, job);
        if(!mJobs.contains(job2)) {
            mJobs.add(job2);
        }
    }
}
