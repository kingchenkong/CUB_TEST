package com.example.cub_test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cub_test.R
import com.example.cub_test.model.json_data.GitHubUsersJSONItem

class UsersListAdapter(
    val context: Context,
    var jsonList: List<GitHubUsersJSONItem>,
    private val itemOnClickCallback: ItemOnClickCallback?,
) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    interface ItemOnClickCallback {
        fun onClick(position: Int, viewHolder: ViewHolder, json: GitHubUsersJSONItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_users_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val json = jsonList[position]

        // download avatar
        Glide.with(context)
            .load(json.avatar_url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .circleCrop()
            .into(holder.ivAvatar)

        // set login
        holder.tvLogin.text = json.login.ifBlank {
            ""
        }
        // set badge
        holder.tvAdmin.visibility = if (json.site_admin) {
            View.VISIBLE
        } else {
            View.GONE
        }

        // onclick callback
        holder.itemView.setOnClickListener {
            itemOnClickCallback?.onClick(position, holder, json)
        }
    }

    override fun getItemCount(): Int {
        return jsonList.count()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivAvatar: ImageView = view.findViewById(R.id.iv_avatar)
        var tvLogin: TextView = view.findViewById(R.id.tv_login)
        var tvAdmin: TextView = view.findViewById(R.id.tv_admin)
    }
}