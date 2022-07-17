package com.example.entity.partitioning;

import javax.persistence.*;
import java.util.*;

@SqlResultSetMapping(name = "Part2RSMapping",
        entities = @EntityResult(entityClass = Part2.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "createdon", column = "createdon"),
                        @FieldResult(name = "name", column = "name")
                }))
@Entity
@Table(name = "part2")
@IdClass(Part2PK.class)
public class Part2 {

    @Id
    private Long id;

    @Id
    private Date createdon;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "part1_part2",
            joinColumns = { @JoinColumn(name = "part2_id", referencedColumnName = "id"), @JoinColumn(name = "part2_createdon", referencedColumnName = "createdon") },
            inverseJoinColumns = { @JoinColumn(name = "part1_id", referencedColumnName = "id"), @JoinColumn(name = "part1_createdon", referencedColumnName = "createdon") }
    )
    private Set<Part1> part1Set = new HashSet<>();

    public Part2() {
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

    public Set<Part1> getPart1Set() {
        return part1Set;
    }

    public void setPart1Set(Set<Part1> part1Set) {
        this.part1Set = part1Set;
    }

    public void addPart1(Part1 p1) {
        Set<Part1> set = Optional.ofNullable(this.getPart1Set()).orElse(new HashSet<>());
        this.setPart1Set(set);
        set.add(p1);
        Set<Part2> set2 = Optional.ofNullable(p1.getPart2Set()).orElse(new HashSet<>());
        set2.add(this);
        p1.setPart2Set(set2);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Part2{");
        builder.append("id=").append(id);
        builder.append(", createdon=").append(createdon);
        builder.append(", name='").append(Optional.ofNullable(name).orElse(""));
        builder.append(", part1Set=").append(Optional.ofNullable(part1Set).map(Objects::toString).orElse("[]"));
        builder.append("}");
        return builder.toString();
    }
}
