package gonzalez.oscar.rickandmortyapp.presentation.ui.locations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import gonzalez.oscar.domain.LocationUniverse
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.LocationViewBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseListPagingAdapter
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseViewHolder

class LocationsViewAdapter : BaseListPagingAdapter<LocationUniverse>(LocationsDiff()) {

    var itemClickListener: ((LocationUniverse, LocationViewBinding) -> Unit)? = null

    override fun getItemLayout() = R.layout.location_view

    override fun getViewHolder(view: View) = LocationViewHolder(view, itemClickListener)
}

class LocationViewHolder(
    private val view: View,
    private val itemClickListener: ((LocationUniverse, LocationViewBinding) -> Unit)?
) : BaseViewHolder<LocationUniverse>(view) {

    override fun bind(item: LocationUniverse) {
        with(LocationViewBinding.bind(view)) {
            nameLocation.text = item.name
            dimensionLocation.text = item.dimension
            typeLocation.text = item.type

            view.setOnClickListener {
                itemClickListener?.invoke(item, this)
            }
        }
    }

    override fun bindPlaceHolder() {
        TODO("Not yet implemented")
    }
}

class LocationsDiff : DiffUtil.ItemCallback<LocationUniverse>() {

    override fun areItemsTheSame(oldItem: LocationUniverse, newItem: LocationUniverse) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: LocationUniverse, newItem: LocationUniverse) = oldItem == newItem
}