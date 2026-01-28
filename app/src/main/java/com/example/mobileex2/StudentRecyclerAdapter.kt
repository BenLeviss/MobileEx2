import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileex2.R
import com.example.mobileex2.Student
import com.example.mobileex2.StudentDetailsActivity

class StudentRecyclerAdapter(private val students: MutableList<Student>) :
    RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView = view.findViewById(R.id.student_row_name)
        val idTv: TextView = view.findViewById(R.id.student_row_id)
        val checkBox: CheckBox = view.findViewById(R.id.student_row_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.nameTv.text = student.name
        holder.idTv.text = student.id
        holder.checkBox.isChecked = student.isChecked

        // When the whole row is clicked
        holder.itemView.setOnClickListener {
            val intent = android.content.Intent(it.context, StudentDetailsActivity::class.java)
            intent.putExtra("student_position", position)
            it.context.startActivity(intent)
        }


        holder.checkBox.setOnClickListener {
            student.isChecked = holder.checkBox.isChecked
        }
    }

    override fun getItemCount(): Int = students.size
}