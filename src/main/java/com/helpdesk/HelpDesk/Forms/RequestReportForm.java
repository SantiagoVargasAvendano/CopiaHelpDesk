package com.helpdesk.HelpDesk.Forms;

import com.helpdesk.HelpDesk.Models.*;
import com.opencsv.bean.CsvBindByPosition;

public class RequestReportForm {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String specification;
    @CsvBindByPosition(position = 2)
    private String creationDate;
    @CsvBindByPosition(position = 3)
    private String endingDate;
    @CsvBindByPosition(position = 4)
    private String status;
    @CsvBindByPosition(position = 5)
    private int inventoryPlate;
    @CsvBindByPosition(position = 6)
    private int equipmentNumber;
    @CsvBindByPosition(position = 7)
    private String userName;
    @CsvBindByPosition(position = 8)
    private String agentsNames;
    @CsvBindByPosition(position = 9)
    private String category;
    @CsvBindByPosition(position = 10)
    private String feedbackSpecification;
    @CsvBindByPosition(position = 11)
    private String feedbackRating;
    @CsvBindByPosition(position = 12)
    private String feedbackDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getInventoryPlate() {
        return inventoryPlate;
    }

    public void setInventoryPlate(int inventoryPlate) {
        this.inventoryPlate = inventoryPlate;
    }

    public int getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(int equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAgentsNames() {
        return agentsNames;
    }

    public void setAgentsNames(String agentsNames) {
        this.agentsNames = agentsNames;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeedbackSpecification() {
        return feedbackSpecification;
    }

    public void setFeedbackSpecification(String feedbackSpecification) {
        this.feedbackSpecification = feedbackSpecification;
    }

    public String getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(String feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}