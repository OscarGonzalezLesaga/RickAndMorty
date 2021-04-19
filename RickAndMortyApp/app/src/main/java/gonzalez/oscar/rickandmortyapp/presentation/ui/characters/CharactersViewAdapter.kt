package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.domain.Status.ALIVE
import gonzalez.oscar.domain.Status.DEAD
import gonzalez.oscar.domain.Status.UNKNOWN
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.presentation.utils.loadImage

class CharactersViewAdapter(private var listCharacters: List<CartoonCharacter> = emptyList()) :
    RecyclerView.Adapter<CharactersViewAdapter.ViewHolder>() {

    fun loadCharacters(newData: List<CartoonCharacter>) {
        listCharacters = newData
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageCharacter: ImageView = view.findViewById(R.id.image_character)
        val nameCharacter: TextView = view.findViewById(R.id.name_character)
        val statusCharacter: TextView = view.findViewById(R.id.status_character)
        val genderCharacter: TextView = view.findViewById(R.id.gender_character)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.character_view, viewGroup, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameCharacter.text = listCharacters[position].name
        holder.statusCharacter.text = listCharacters[position].status.toString()
        holder.genderCharacter.text = listCharacters[position].gender.toString()
        holder.imageCharacter.loadImage(listCharacters[position].image)
        val colorStatus = when (listCharacters[position].status) {
            ALIVE -> Color.GREEN
            DEAD -> Color.RED
            UNKNOWN -> Color.WHITE
        }
        holder.statusCharacter.setTextColor(colorStatus)
    }

    override fun getItemCount() = listCharacters.size
}