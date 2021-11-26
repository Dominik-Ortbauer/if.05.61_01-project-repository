package org.example;

import java.util.LinkedList;
import java.util.List;

public class JobScheduler
{
    private List<Job> mTotallyIndependentJobs = new LinkedList<>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if(hasJob(jobName) == null) {
            mTotallyIndependentJobs.add(job);
        }
    }

    public void sort() {
        
    }

    public String getList() {
        String s = "";
        for(Job job : mTotallyIndependentJobs) {
            s += job.toString();
        }

        return s;
    }

    private Job hasJob(String jobName) {
        for(Job job : mTotallyIndependentJobs) {
            Job out = job.hasJob(jobName);
            if(out != null) return out;
        }

        return null;
    }

    public void registerJob(String dependentJob, String independentJob) {
        Job independent = hasJob(independentJob);
        Job dependent = hasJob(dependentJob);

        if (independent == null) {
            independent = new Job(independentJob);
            mTotallyIndependentJobs.add(independent);
        }
        if(dependent == null) {
            independent.addSubJob(dependentJob);
        } else {
            if(mTotallyIndependentJobs.contains(dependent)) {
                mTotallyIndependentJobs.remove(dependent);
                independent.addSubJob(dependent);
            }
        }
    }
}
