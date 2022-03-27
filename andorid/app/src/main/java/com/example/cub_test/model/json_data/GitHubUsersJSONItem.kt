package com.example.cub_test.model.json_data

data class GitHubUsersJSONItem(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
) : java.io.Serializable {
    override fun toString(): String {
        return "GitHubUsersJSON2Item(\n" +
                " avatar_url='$avatar_url,\n" +
                " events_url='$events_url,\n" +
                " followers_url='$followers_url,\n" +
                " following_url='$following_url,\n" +
                " gists_url='$gists_url,\n" +
                " gravatar_id='$gravatar_id,\n" +
                " html_url='$html_url,\n" +
                " id=$id,\n" +
                " login='$login,\n" +
                " node_id='$node_id,\n" +
                " organizations_url='$organizations_url,\n" +
                " received_events_url='$received_events_url,\n" +
                " repos_url='$repos_url,\n" +
                " site_admin=$site_admin,\n" +
                " starred_url='$starred_url,\n" +
                " subscriptions_url='$subscriptions_url,\n" +
                " type='$type,\n" +
                " url='$url'\n" +
                ")"
    }
}
