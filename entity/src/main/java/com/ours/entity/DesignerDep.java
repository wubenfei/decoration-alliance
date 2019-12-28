package com.ours.entity;

public class DesignerDep {
    private String designerJob;

    private String depId;

    public String getDesignerJob() {
        return designerJob;
    }

    public void setDesignerJob(String designerJob) {
        this.designerJob = designerJob;
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
        sb.append(", designerJob=").append(designerJob);
        sb.append(", depId=").append(depId);
        sb.append("]");
        return sb.toString();
    }
}