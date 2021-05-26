package gonzalez.oscar.rickandmortyapp.presentation.ui.episodes

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import gonzalez.oscar.domain.Episode
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.EpisodeViewBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseListPagingAdapter
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseViewHolder

class EpisodesViewAdapter : BaseListPagingAdapter<Episode>(EpisodeDiff()) {

    var itemClickListener: ((Episode, EpisodeViewBinding) -> Unit)? = null

    override fun getItemLayout() = R.layout.episode_view

    override fun getViewHolder(view: View) = EpisodeViewHolder(view, itemClickListener)
}

class EpisodeViewHolder(
    private val view: View,
    private val itemClickListener: ((Episode, EpisodeViewBinding) -> Unit)?
) : BaseViewHolder<Episode>(view) {

    override fun bind(item: Episode) {
        with(EpisodeViewBinding.bind(view)) {
            nameEpisode.text = item.name
            dateEpisode.text = item.date
            numberEpisode.text = item.number
            view.setOnClickListener {
                itemClickListener?.invoke(item, this)
            }
        }
    }

    override fun bindPlaceHolder() {
        TODO("Not yet implemented")
    }
}

class EpisodeDiff : DiffUtil.ItemCallback<Episode>() {

    override fun areItemsTheSame(oldItem: Episode, newItem: Episode) = oldItem.number == newItem.number

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode) = oldItem == newItem
}