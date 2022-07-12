package com.example.entity.partitioning;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "part1")
@IdClass(Part1PK.class)
public class Part1 {

    @Id
    private Long id;

    @Id
    private Date createdon;

    private String name;

    @ManyToMany(mappedBy = "part1Set", fetch = FetchType.LAZY)
    private Set<Part2> part2Set = new HashSet<>();

    public Part1() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Part2> getPart2Set() {
        return part2Set;
    }

    public void setPart2Set(Set<Part2> part2Set) {
        this.part2Set = part2Set;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Part1{");
        builder.append("id=").append(id);
        builder.append(", createdon=").append(createdon);
        builder.append(", name='").append(Optional.ofNullable(name).orElse(""));
        builder.append("}");
        return builder.toString();
    }
}
