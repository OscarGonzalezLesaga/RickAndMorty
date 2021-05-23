package gonzalez.oscar.rickandmortyapp.presentation.ui.detailcharacter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.rickandmortyapp.databinding.ActivityDetailCharacterBinding
import gonzalez.oscar.rickandmortyapp.presentation.utils.loadImage

class DetailCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCharacterBinding

    companion object {

        const val CHARACTER_EXTRA = "character extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val character = intent.extras?.getSerializable(CHARACTER_EXTRA) as CartoonCharacter
        with(binding) {
            imageView.loadImage(character.image)
            nameCharacter.text = character.name
        }
    }
}