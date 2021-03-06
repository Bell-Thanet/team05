package com.cpe.backend.Returns.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.cpe.backend.borrow.entity.Borrow;
import com.cpe.backend.Employee.entity.Employee;
import com.cpe.backend.Members.entity.Members;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Returns")
public class Returns {
    @Id
    @SequenceGenerator(name = "Return_seq", sequenceName = "Return_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Return_seq")

    private @NonNull Long return_id;
    @NotNull
    @FutureOrPresent
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @NonNull LocalDate timeReturn;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "Status_ID", insertable = true)
    @NotNull
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "Employee_ID", insertable = true)
    @NotNull
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Members.class)
    @JoinColumn(name = "MEMBERS_ID", insertable = true)
    @NotNull
    private Members member;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Borrow.class)
    @JoinColumn(name = "BORROW_ID", insertable = true)
    @JsonManagedReference
    @NotNull
    private Borrow borrow;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setMember(Members members) {
        this.member = members;
    }

    public void setStatus(Status statuss) {
        this.status = statuss;
    }

    public void setTimeReturn(LocalDate now) {
        this.timeReturn = now;
    }

	public void setBorrow(Borrow borrows) {
        this.borrow = borrows;
	}
}