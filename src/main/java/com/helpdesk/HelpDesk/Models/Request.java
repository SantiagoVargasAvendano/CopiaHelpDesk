package com.helpdesk.HelpDesk.Models;

import com.helpdesk.HelpDesk.ProjectAssistances.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id_Gen")
    @Size(max = 255)
    @GenericGenerator(
            name = "Id_Gen",
            strategy = "com.helpdesk.HelpDesk.ProjectAssistances.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "FI"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;

    @Lob
    @NotEmpty
    private String specification;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endingDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer inventoryPlate;

    @Max(10)
    @Min(0)
    private int equipmentNumber;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "agent_request",
            joinColumns = {
                    @JoinColumn(name = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "username")
            })
    private Set<User> agents;

    @ManyToOne
    private Category category;

    @OneToOne
    private Feedback feedback;

    public Request() {}

    public Request(String specification, User user){
        this.specification = specification;
        this.creationDate = Calendar.getInstance(TimeZone.getTimeZone("GMT-5:00"));
        this.status = Status.NO_ASIGNADO;
        this.user = user;
    }
    public Request(String specification, User user, Integer inventoryPlate, int equipmentNumber){
        this.specification = specification;
        this.creationDate = Calendar.getInstance(TimeZone.getTimeZone("GMT-5:00"));
        this.status = Status.NO_ASIGNADO;
        this.user = user;
        this.inventoryPlate = inventoryPlate;
        this.equipmentNumber = equipmentNumber;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Category getCategory() {
        return category;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setInventoryPlate(Integer inventoryPlate) {
        this.inventoryPlate = inventoryPlate;
    }

    public void setEquipmentNumber(int equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAgents(Set<User> agents) {
        this.agents = agents;
    }

    public void setAgents(User agent){
        this.agents = Set.of(agent);
    }

    public String getId() {
        return id;
    }

    public String getSpecification() {
        return specification;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getInventoryPlate() {
        return inventoryPlate;
    }

    public int getEquipmentNumber() {
        return equipmentNumber;
    }

    public User getUser() {
        return user;
    }

    public Set<User> getAgents() {
        return agents;
    }

    public String formatCreationDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        return dateFormat.format(this.creationDate.getTime());
    }

    public String formatEndingDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        return this.endingDate != null ? dateFormat.format(this.endingDate.getTime()) : null;
    }

    public enum Status{
        ACTIVO, CERRADO, CERRADO_SIN_CALIFICACION, CERRADO_POR_ESCALAMIENTO, NO_ASIGNADO
    }
}

