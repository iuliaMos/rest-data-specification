package com.example.entity.partitioning;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Part1PK implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="part1_seq")
    @SequenceGenerator(name="part1_seq", sequenceName="part1_seq", allocationSize=1)
    private Long id;

    private Date createdon;

    public Part1PK() {
    }

    public Part1PK(Long id, Date createdon) {
        this.id = id;
        this.createdon = createdon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Part1PK)) return false;
        Part1PK that = (Part1PK) o;
        return Objects.equals(getCreatedon(), that.getCreatedon()) && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedon());
    }

}
