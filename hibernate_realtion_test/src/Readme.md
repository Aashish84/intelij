# relations :
    * OneToOne : one user has one laptop
    * OneToMany : one customer has many order

---

# questions :
### Modeling a Unidirectional One-to-Many Relationship without Creating Extra Table in JPA

```java
@Entity
public class Book {
@Id
private Long id;
    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Chapter> chapters;
}

@Entity
public class Chapter {
@Id
private Long id;
    @Column(name = "book_id")
    private Long bookId;
//    same database even without above line but should rely on cascade
}
```
---
### OneToMany relationship without creating extra table jpa and bidirectional
```java
@Entity
public class Department {
    @Id
    private Long id;

    // other fields

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // getters and setters
}

@Entity
public class Employee {
    @Id
    private Long id;

    // other fields

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}
```