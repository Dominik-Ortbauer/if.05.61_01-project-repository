package org.example;

import java.util.LinkedList;
import java.util.List;

public class Job {
    private String name;
    private Job dependsOn;
    private List<Job> dependOnThis = new LinkedList<>();

    public Job(String name, Job dependsOn) {
        this.name = name;
        this.dependsOn = dependsOn;
    }

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Job getDependency() {
        return dependsOn;
    }

    public void addSubJob(String job) {
        dependOnThis.add(new Job(job));
    }

    public void addSubJob(Job job) {
        dependOnThis.add(job);
    }

    public Job hasJob(String name) {
        if(this.name == name) return this;

        for(Job job : dependOnThis) {
            if(job.hasJob(name) != null) return job;
        }

        return null;
    }

    @Override
    public String toString() {
        String s = name;

        for(Job job : dependOnThis) {
            s += job.toString();
        }

        return s;
    }
}
