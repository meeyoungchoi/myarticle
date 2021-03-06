package com.example.myarticle.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article  extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private int cnt;

    //하나의 게시글에 여러 댓글이 달린다
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article() {
    }

    @Builder
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.cnt = 0;
    }



    public void rewrtie(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public void increase() {
        this.cnt += 1;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cnt=" + cnt +
                '}';
    }

    public void stickTo(Comment saved) {

    }

    public List<Comment> getComments() {
        return comments;
    }


}
