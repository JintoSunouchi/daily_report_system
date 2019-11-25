package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "timecards")
@NamedQueries({
        @NamedQuery(name = "getAllTimeCards", query = "SELECT t FROM TimeCard AS t ORDER BY t.id DESC"),
        @NamedQuery(name = "getTimeCardsCount", query = "SELECT COUNT(t) FROM TimeCard AS t"),
})
@Entity
public class TimeCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "timecard_date", nullable = false)
    private Date timecard_date;

    @Column(name = "attendance_at", nullable = false)
    private Timestamp attendance_at;

    @Column(name = "retirement_at", nullable = false)
    private Timestamp retirement_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimecard_date() {
        return timecard_date;
    }

    public void setTimecard_date(Date timecard_date) {
        this.timecard_date = timecard_date;
    }

    public Timestamp getAttendance_at() {
        return attendance_at;
    }

    public void setAttendance_at(Timestamp attendance_at) {
        this.attendance_at = attendance_at;
    }

    public Timestamp getRetirement_at() {
        return retirement_at;
    }

    public void setRetirement_at(Timestamp retirement_at) {
        this.retirement_at = retirement_at;
    }
}
