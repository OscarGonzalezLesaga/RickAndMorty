package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseListAdapter<T>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<T>>(diffUtil) {

    @LayoutRes
    abstract fun getItemLayout(): Int

    abstract fun getViewHolder(view: View): BaseViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = getViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(getItemLayout(), parent, false)
    )

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }
}

abstract class BaseViewHolder<T>(view: View) : ViewHolder(view) {

    abstract fun bind(item: T)
}