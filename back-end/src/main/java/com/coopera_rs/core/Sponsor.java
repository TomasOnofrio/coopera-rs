package com.coopera_rs.core;

import java.util.Objects;

public class Sponsor {

    private Long id;
    private String name;
    private String imageUrl;
    private String url;

    public Sponsor(){}

    public Sponsor(Long id, String name, String imageUrl, String url) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        if (id != null ? !id.equals(sponsor.id) : sponsor.id != null) return false;
        if (name != null ? !name.equals(sponsor.name) : sponsor.name != null) return false;
        return name != null ? name.equals(sponsor.name) : sponsor.name == null;
    }

    @Override
    public int hashCode() {return Objects.hash(id, name, imageUrl, url);}
}
