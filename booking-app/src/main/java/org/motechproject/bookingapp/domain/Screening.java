package org.motechproject.bookingapp.domain;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.LocalDate;
import org.motechproject.bookingapp.util.CustomDateSerializer;
import org.motechproject.bookingapp.util.CustomTimeSerializer;
import org.motechproject.commons.date.model.Time;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.NonEditable;

@Entity(maxFetchDepth = 3)
public class Screening {

    public static final String DATE_PROPERTY_NAME = "date";

    @Field
    private Long id;

    @Field
    private Clinic clinic;

    @Field(required = true)
    private Volunteer volunteer;

    @Field(required = true)
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate date;

    @Field
    private String name;

    @Field
    private String phone;

    @Field(required = true)
    @JsonSerialize(using = CustomTimeSerializer.class)
    private Time startTime;

    @Field(required = true)
    @JsonSerialize(using = CustomTimeSerializer.class)
    private Time endTime;

    @NonEditable(display = false)
    @Field
    private String owner;

    public ScreeningDto toDto() {
        ScreeningDto dto = new ScreeningDto();
        dto.setId(getId().toString());
        dto.setClinicId(getClinic().getId().toString());
        dto.setVolunteerId(volunteer.getId().toString());
        dto.setDate(date.toString());
        dto.setStartTime(startTime.toString());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
