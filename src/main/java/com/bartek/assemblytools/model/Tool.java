package com.bartek.assemblytools.model;

import com.bartek.assemblytools.model.enums.Line;
import com.bartek.assemblytools.model.enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Tool {
    private long id;
    private String toolNumber;
    private Status status;
    private LocalDate dateOfTransfer;
    private Line line;
    private String product;
    private String whoName;
    private String comments;

    public Tool() {
    }

    public Tool(long toolId, String toolNumber, Status status, Line line, String product, String whoName, String comments) {
        this.id = toolId;
        this.toolNumber = toolNumber;
        this.status = status;
        this.line = line;
        this.product = product;
        this.whoName = whoName;
        this.comments = comments;
        this.dateOfTransfer= LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getToolNumber() {
        return toolNumber;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDateOfTransfer() {
        return dateOfTransfer;
    }

    public Line getLine() {
        return line;
    }

    public String getProduct() {
        return product;
    }

    public String getWhoName() {
        return whoName;
    }

    public String getComments() {
        return comments;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setToolNumber(String toolNumber) {
        this.toolNumber = toolNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDateOfTransfer(LocalDate dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setWhoName(String whoName) {
        this.whoName = whoName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "tool{" +
                "toolId=" + id +
                ", toolNumber='" + toolNumber + '\'' +
                ", status='" + status + '\'' +
                ", dateOfTransfer=" + dateOfTransfer +
                ", line='" + line + '\'' +
                ", product='" + product + '\'' +
                ", whoName='" + whoName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return id == tool.id &&
                Objects.equals(toolNumber, tool.toolNumber) &&
                Objects.equals(status, tool.status) &&
                Objects.equals(dateOfTransfer, tool.dateOfTransfer) &&
                Objects.equals(line, tool.line) &&
                Objects.equals(product, tool.product) &&
                Objects.equals(whoName, tool.whoName) &&
                Objects.equals(comments, tool.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, toolNumber, status, dateOfTransfer, line, product, whoName, comments);
    }
}
