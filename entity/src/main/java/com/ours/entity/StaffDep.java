package com.ours.entity;

public class StaffDep {
    /**
     * 员工工号
     */
    private String jobNumber;

    /**
     * 所述部门id
     */
    private String depId;

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", depId=").append(depId);
        sb.append("]");
        return sb.toString();
    }
}