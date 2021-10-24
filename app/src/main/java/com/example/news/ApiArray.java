package com.example.news;

import java.util.ArrayList;

public class ApiArray {
    // response of api status & totalResults
    private String status, totalResults;
    // articles and articles in array form see websites Newsapi.org
    private ArrayList<Modal> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResults() {
        return totalResults;
    }

    public void setResults(String results) {
        this.totalResults = results;
    }

    public ArrayList<Modal> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Modal> articles) {
        this.articles = articles;
    }

    public ApiArray(String status, String results, ArrayList<Modal> articles) {
        this.status = status;
        this.totalResults = results;
        this.articles = articles;
    }
}
