package com.murielgonzalez.github.model;


import com.google. gson.annotations.SerializedName;


/**
 * Created by muriel_gonzalez on 5/23/17.
 */


public class Item {
    @SerializedName("name")
    private String name;

    @SerializedName("html_url")
    private String repoUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("default_branch")
    private String branch;


    public String getName() {
        return name;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getBranch() {
        return branch;
    }

    public Item(String name, String repoUrl, String description, String branch) {
        this.name = name;
        this.repoUrl = repoUrl;
        this.description = description;
        this.branch = branch;

    }
}
