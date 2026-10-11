package com.devboard.statsservice.model;

public class ProjectStats {
    private long total;
    private long pending;
    private long inProgress;
    private long completed;

    public ProjectStats() {
    }

    public ProjectStats(long total, long pending, long inProgress, long completed) {
        this.total = total;
        this.pending = pending;
        this.inProgress = inProgress;
        this.completed = completed;
    }

    public long getTotal() {
        return total;
    }

    public long getPending() {
        return pending;
    }

    public long getInProgress() {
        return inProgress;
    }

    public long getCompleted() {
        return completed;
    }
}
