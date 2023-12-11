package com.example.task3

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

public class IngredientAdapter(private val itemList: MutableList<Ingredient>):
    RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    private var onSumChangeListener: OnSumChangeListener? = null

    interface OnSumChangeListener {
        fun onSumChanged(sum: Double)
    }

    private fun addEmptyItem() {
        itemList.add(Ingredient("", null,null, null))
        notifyItemInserted(itemList.size - 1)
    }

    private fun checkLastItem() {
        val lastItemPosition = itemList.size - 1

        if (lastItemPosition >= 0) {
            val lastItem = itemList[lastItemPosition]
            if (lastItem.volume != null || !lastItem.name.isNullOrEmpty() || lastItem.price != null || lastItem.quantity != null) {
                addEmptyItem()
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameEditText: EditText = itemView.findViewById(R.id.name)
        val volumeEditText: EditText = itemView.findViewById(R.id.volume)
        val quantityEditText: EditText = itemView.findViewById(R.id.quantity)
        val priceEditText: EditText = itemView.findViewById(R.id.price)

        init {
            nameEditText.addTextChangedListener(createTextWatcher())
            volumeEditText.addTextChangedListener(createTextWatcher())
            quantityEditText.addTextChangedListener(createTextWatcher())
            priceEditText.addTextChangedListener(createTextWatcher())
        }


    }

    private fun createTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                updateSum()
                checkLastItem()
            }

            override fun afterTextChanged(editable: Editable?) {}
        }
    }

    private fun updateSum() {
        val sum = itemList.sumOf {
            it.getTotalPrice()
        }

        onSumChangeListener?.onSumChanged(sum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.ingredient_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.nameEditText.setText(item.name)
        holder.volumeEditText.setText(item.volume.toString())
        holder.quantityEditText.setText(item.quantity.toString())
        holder.priceEditText.setText(item.price.toString())
    }
}