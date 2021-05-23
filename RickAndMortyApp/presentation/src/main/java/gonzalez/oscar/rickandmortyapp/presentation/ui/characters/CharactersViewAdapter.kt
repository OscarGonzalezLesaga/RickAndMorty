package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.domain.Status.ALIVE
import gonzalez.oscar.domain.Status.DEAD
import gonzalez.oscar.domain.Status.UNKNOWN
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.CharacterViewBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseListAdapter
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseViewHolder
import gonzalez.oscar.rickandmortyapp.presentation.utils.loadImage

class CharactersViewAdapter : BaseListAdapter<CartoonCharacter>(CartoonCharacterDiff()) {

    override fun getItemLayout() = R.layout.character_view

    override fun getViewHolder(view: View) = CharacterViewHolder(view)
}

class CharacterViewHolder(private val view: View) : BaseViewHolder<CartoonCharacter>(view) {

    override fun bind(item: CartoonCharacter) {
        with(CharacterViewBinding.bind(view)) {
            nameCharacter.text = item.name
            statusCharacter.text = item.status.toString()
            genderCharacter.text = item.gender.toString()
            imageCharacter.loadImage(item.image)
            val colorStatus = when (item.status) {
                ALIVE -> Color.GREEN
                DEAD -> Color.RED
                UNKNOWN -> Color.BLUE
            }
            statusCharacter.setTextColor(colorStatus)
        }
    }
}

class CartoonCharacterDiff : DiffUtil.ItemCallback<CartoonCharacter>() {

    override fun areItemsTheSame(oldItem: CartoonCharacter, newItem: CartoonCharacter) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: CartoonCharacter, newItem: CartoonCharacter) = oldItem == newItem
}