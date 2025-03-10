import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.takrorlash.R
import com.example.takrorlash.databinding.ListItemBinding
import com.example.takrorlash.models.User

class CustomUserAdapter(context: Context, val list: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.list_item, list) {
    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: ListItemBinding = if (convertView == null) {
            ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ListItemBinding.bind(convertView)
        }
        binding.userNameTextView.text = list[position].name
        binding.userAgeTextView.text = list[position].age.toString()
        return binding.root
    }
}