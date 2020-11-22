package com.helpdesk.HelpDesk.Forms;

import com.helpdesk.HelpDesk.Models.BoundingType;
import com.helpdesk.HelpDesk.Models.Request;
import com.helpdesk.HelpDesk.Models.User;
import com.opencsv.bean.CsvBindByPosition;

public class BoundingTypeReportForm {

    @CsvBindByPosition(position = 0)
    private String boundingType;

    @CsvBindByPosition(position = 1)
    private int equipementNumber;

    @CsvBindByPosition(position = 2)
    private int requestsNumber;

    @CsvBindByPosition(position = 3)
    private int excelentNumber;

    @CsvBindByPosition(position = 4)
    private int goodNumber;

    @CsvBindByPosition(position = 5)
    private int regularNumber;

    @CsvBindByPosition(position = 6)
    private int badNumber;

    @CsvBindByPosition(position = 7)
    private int deficientNumber;

    public BoundingTypeReportForm(BoundingType boundingType) {
        this.boundingType = boundingType.getName();
        this.equipementNumber = 0;
        this.requestsNumber = 0;
        this.excelentNumber = 0;
        this.goodNumber = 0;
        this.regularNumber = 0;
        this.badNumber = 0;
        this.deficientNumber = 0;

        for(User user : boundingType.getUsers()){
            for(Request request : user.getRequests()){
                this.equipementNumber += request.getEquipmentNumber();
                this.requestsNumber++;
                if(request.getStatus() == Request.Status.CERRADO){
                    switch (request.getFeedback().getRating().getName()){
                        case "Excelente":
                            this.excelentNumber++;
                            break;
                        case "Bueno":
                            this.goodNumber++;
                            break;
                        case "Regular":
                            this.regularNumber++;
                            break;
                        case "Malo":
                            this.badNumber++;
                            break;
                        case "Deficiente":
                            this.deficientNumber++;
                            break;
                    }
                }
            }
        }
    }

    public BoundingTypeReportForm(){ }

    public String getBoundingType() {
        return boundingType;
    }

    public void setBoundingType(String boundingType) {
        this.boundingType = boundingType;
    }

    public int getEquipementNumber() {
        return equipementNumber;
    }

    public void setEquipementNumber(int equipementNumber) {
        this.equipementNumber = equipementNumber;
    }

    public int getRequestsNumber() {
        return requestsNumber;
    }

    public void setRequestsNumber(int requestsNumber) {
        this.requestsNumber = requestsNumber;
    }

    public int getExcelentNumber() {
        return excelentNumber;
    }

    public void setExcelentNumber(int excelentNumber) {
        this.excelentNumber = excelentNumber;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public int getRegularNumber() {
        return regularNumber;
    }

    public void setRegularNumber(int regularNumber) {
        this.regularNumber = regularNumber;
    }

    public int getBadNumber() {
        return badNumber;
    }

    public void setBadNumber(int badNumber) {
        this.badNumber = badNumber;
    }

    public int getDeficientNumber() {
        return deficientNumber;
    }

    public void setDeficientNumber(int deficientNumber) {
        this.deficientNumber = deficientNumber;
    }

}
