package com.example.cub_test.model.json_data

import androidx.annotation.Nullable

data class GitHubUserDetailJSON(
    val avatar_url: String,
    val bio: String,
    val blog: String,
    val company: Any,
    val created_at: String,
    val email: Any,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Any,
    val html_url: String,
    val id: Int,
    @Nullable val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val twitter_username: Any,
    val type: String,
    val updated_at: String,
    val url: String
) {
    override fun toString(): String {
        return "GitHubUserDetailJSON(\n" +
                " avatar_url='$avatar_url',\n" +
                " bio='$bio',\n" +
                " blog='$blog',\n" +
                " company=$company,\n" +
                " created_at='$created_at',\n" +
                " email=$email,\n" +
                " events_url='$events_url',\n" +
                " followers=$followers,\n" +
                " followers_url='$followers_url',\n" +
                " following=$following,\n" +
                " following_url='$following_url',\n" +
                " gists_url='$gists_url',\n" +
                " gravatar_id='$gravatar_id',\n" +
                " hireable=$hireable,\n" +
                " html_url='$html_url',\n" +
                " id=$id,\n" +
                " location=$location,\n" +
                " login='$login',\n" +
                " name='$name',\n" +
                " node_id='$node_id',\n" +
                " organizations_url='$organizations_url',\n" +
                " public_gists=$public_gists,\n" +
                " public_repos=$public_repos,\n" +
                " received_events_url='$received_events_url',\n" +
                " repos_url='$repos_url',\n" +
                " site_admin=$site_admin,\n" +
                " starred_url='$starred_url',\n" +
                " subscriptions_url='$subscriptions_url',\n" +
                " twitter_username=$twitter_username,\n" +
                " type='$type',\n" +
                " updated_at='$updated_at',\n" +
                " url='$url'\n" +
                ")"
    }
}