package com.murielgonzalez.github.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muriel_gonzalez on 5/29/17.
 */

public class RepoOwner implements Serializable {
    @SerializedName("avatar_url")
    private String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void RepoOwner(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
