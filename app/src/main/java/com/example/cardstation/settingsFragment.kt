import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.cardstation.R


class settingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val button: Button = view.findViewById(R.id.btn2)
        button.setOnClickListener {
            showConfirmationDialog()
        }

        return view
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("هل تريد الخروج من التطبيق؟")
        builder.setMessage("هل أنت متأكد؟")
        builder.setPositiveButton("نعم") { dialog, which ->
            activity?.finish()
        }
        builder.setNegativeButton("الغاء") { dialog, which ->

        }
        builder.show()
    }
}