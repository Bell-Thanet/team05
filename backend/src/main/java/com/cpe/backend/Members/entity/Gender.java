package com.cpe.backend.Members.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@Entity
@NoArgsConstructor
@Table(name="GENDER")
public class Gender {
    @Id
    @SequenceGenerator(name="GENDER_SEQ",sequenceName="GENDER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GENDER_SEQ")
    private @NonNull Long gender_id;

    @NotNull
    @Size(min = 3,max = 10)
    private String gender;
    
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Members> members;
    
	public void setGender(String gender) {
        this.gender=gender;
	}
}