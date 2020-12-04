package com.helpdesk.HelpDesk.Forms;

import com.helpdesk.HelpDesk.Models.Category;
import com.helpdesk.HelpDesk.Models.Request;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.time.Duration;

public class CategoryReportForm {

    public static String[]  columnas = {
            "Numero de equipos",
            "Numero de solicitudes",
            "Promedio de calificación",
            "Eficacia",
            "Duración promedio (días)"
    };

    @CsvBindByName(column = "Categoría")
    @CsvBindByPosition(position = 0)
    private String category;

    @CsvBindByName(column = "Numero de equipos")
    @CsvBindByPosition(position = 1)
    private String pos0;

    @CsvBindByName(column = "Numero de solicitudes")
    @CsvBindByPosition(position = 2)
    private String pos1;

    @CsvBindByName(column = "Promedio de calificación")
    @CsvBindByPosition(position = 3)
    private String pos2;

    @CsvBindByName(column = "Eficacia")
    @CsvBindByPosition(position = 4)
    private String pos3;

    @CsvBindByName(column = "Duración promedio (días)")
    @CsvBindByPosition(position = 5)
    private String pos4;

    public CategoryReportForm(Category category, boolean[] toShow) {
        this.pos0 = null;
        this.pos1 =null;
        this.pos2 = null;
        this.pos3 = null;
        this.pos4 = null;
        this.category = category.getName();


        float[] numbers = new float[toShow.length];
        int numberClosedFeedbackRequests = 0;
        int numberClosedRequests = 0;
        for(int i = 0; i < toShow.length; ++i){
            if(toShow[i]){
                numbers[i] = 0;
            }
        }
        for(Request request : category.getRequests()){
            numbers[0] += request.getEquipmentNumber();
            numbers[1]++;

            if(request.getStatus() == Request.Status.CERRADO || request.getStatus() == Request.Status.CERRADO_SIN_CALIFICACION){
                numberClosedRequests++;
                numbers[4] += Math.abs(request.getEndingDate().getTime().getTime() - request.getCreationDate().getTime().getTime())/(1000.0 * 60 * 60 * 24);
                System.out.println("aumento " + Math.abs(request.getEndingDate().getTime().getTime() - request.getCreationDate().getTime().getTime())/(1000.0 * 60 * 60 * 24));
                if(request.getStatus() == Request.Status.CERRADO){
                    numberClosedFeedbackRequests++;
                    if(request.getFeedback().isSuccessful()){
                        numbers[3]++;
                    }
                    numbers[2] += request.getFeedback().getRating();
                }
            }
        }



        numbers[2] /= numberClosedFeedbackRequests;
        numbers[3] /= numberClosedFeedbackRequests;
        numbers[4] /= numberClosedRequests;

        for(int i = 0; i < toShow.length; ++i){
            if(toShow[i]){
                String result = Math.ceil(numbers[i]) == numbers[i] ? (int) numbers[i] + "" : String.format("%.2f", numbers[i]) + "";
                if(pos0 == null){
                    pos0 = result;
                }else if(pos1 == null){
                    pos1 = result;
                }else if(pos2 == null){
                    pos2 = result;
                }else if(pos3 == null){
                    pos3 = result;
                }else if(pos4 == null){
                    pos4 = result;
                }
            }
        }
    }

    public CategoryReportForm(){ }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPos0(String pos0) {
        this.pos0 = pos0;
    }

    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }

    public void setPos3(String pos3) {
        this.pos3 = pos3;
    }

    public String getPos0() {
        return pos0;
    }

    public String getPos1() {
        return pos1;
    }

    public String getPos2() {
        return pos2;
    }

    public String getPos3() {
        return pos3;
    }

    public void setPos4(String pos4) {
        this.pos4 = pos4;
    }

    public String getPos4() {
        return pos4;
    }
}
