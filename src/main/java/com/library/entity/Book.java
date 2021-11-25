package com.library.entity;
import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 45)
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @Column(nullable = false, length = 4)
    private Integer publishDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Override
    public String toString() {
        if(user!=null){
            return "Book{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", publishDate=" + publishDate +
                    ", user=" + user.getFirstName()+" "+user.getLastName()+" with id: "+user.getId() +
                    '}';
        }else{
            return "Book{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", publishDate=" + publishDate +
                     '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
