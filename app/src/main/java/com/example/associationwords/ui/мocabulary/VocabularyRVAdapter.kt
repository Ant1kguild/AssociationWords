package com.example.associationwords.ui.мocabulary

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.associationwords.R
import com.example.associationwords.databinding.RecyclerViewItemBinding
import com.example.associationwords.model.WordsFirestore
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class VocabularyRVAdapter(private val data: List<WordsFirestore>) :
    RecyclerView.Adapter<VocabularyRVAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "VocabularyRVAdapter"
        val testData = listOf<WordsFirestore>(
            WordsFirestore("man", listOf("test")),
            WordsFirestore("sky", listOf("test", "test")),
            WordsFirestore("dog", listOf("test", "test", "test")),
            WordsFirestore("car", listOf("test", "test", "test", "test")),
            WordsFirestore("month", listOf("test", "test", "test", "test", "test"))

        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VocabularyRVAdapter.ViewHolder {
        val binding =
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VocabularyRVAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val view: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(position: Int) {
            var status = true
            view.tvRcvItemText.text = data[position].word
            view.root.setOnClickListener {
                when (status) {
                    false -> {
                        status = true
                        it.root_layout.background =
                            view.root.context.getDrawable(R.drawable.rcv_main_sharpe_normal)
                        it.iv_arrow.visibility = View.INVISIBLE
                    }
                    true -> {
                        status = false
                        it.root_layout.background =
                            view.root.context.getDrawable(R.drawable.rcv_main_sharpe_presser)
                        it.iv_arrow.visibility = View.VISIBLE
                    }
                }
            }

            view.executePendingBindings()
        }
    }
}

//class ModelInformationAdapter(val firestoreDatabase: FirestoreDatabase) :
//    RecyclerView.Adapter<ModelInformationAdapter.ViewHolder>() {
//
//
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(position)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = RowModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int = data.size
//    fun updateData(it: List<ModelPreview>) {
//        data = it
//        notifyDataSetChanged()
//    }
//
//
//    inner class ViewHolder(private val view: RowModelBinding) : RecyclerView.ViewHolder(view.root) {
//        fun bind(position: Int) {
//            view.modelPreview = data[position]
//            firestoreDatabase.getImage(data[position])
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    Glide.with(view.ivModelView.context)
//                        .load(it)
//                        .centerInside()
//                        .transform(RoundedCorners(58))
//                        .into(view.ivModelView)
//                }, {
//
//                })
//
//            view.root.setOnClickListener {
//                val action = ModelListFragmentDirections.actionModelListFragmentToArCoreFragment(data[position].uuid)
//                view.root.findNavController().navigate(action)
//            }
//
//            view.executePendingBindings()
//        }
//    }
//
//    companion object {
//        private const val TAG = "ModelInformationAdapter"
//    }
//
//}