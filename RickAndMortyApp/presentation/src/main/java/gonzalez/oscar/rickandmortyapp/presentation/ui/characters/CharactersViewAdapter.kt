package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.domain.Status.ALIVE
import gonzalez.oscar.domain.Status.DEAD
import gonzalez.oscar.domain.Status.UNKNOWN
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.CharacterViewBinding
import gonzalez.oscar.rickandmortyapp.presentation.utils.loadImage

class CharactersViewAdapter(private var listCharacters: List<CartoonCharacter> = emptyList()) :
    RecyclerView.Adapter<CharactersViewAdapter.ViewHolder>() {

    fun loadCharacters(newData: List<CartoonCharacter>) {
        listCharacters = newData
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CharacterViewBinding.bind(view)

        fun bind(character: CartoonCharacter) {
            with(binding) {
                nameCharacter.text = character.name
                statusCharacter.text = character.status.toString()
                genderCharacter.text = character.gender.toString()
                imageCharacter.loadImage(character.image)
                val colorStatus = when (character.status) {
                    ALIVE -> Color.GREEN
                    DEAD -> Color.RED
                    UNKNOWN -> Color.WHITE
                }
                statusCharacter.setTextColor(colorStatus)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.character_view, viewGroup, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    override fun getItemCount() = listCharacters.size
}