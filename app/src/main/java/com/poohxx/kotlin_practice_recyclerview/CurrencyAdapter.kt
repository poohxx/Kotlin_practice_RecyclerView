package com.poohxx.kotlin_practice_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poohxx.kotlin_practice_recyclerview.databinding.CurrencyItemBinding

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>(){
    val currencyList = ArrayList<Currency>()

    class CurrencyHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CurrencyItemBinding.bind(item)
        fun bind(currency: Currency) = with(binding){
            im.setImageResource(currency.imageId)
            tvTitle.text = currency.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return CurrencyHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        holder.bind(currencyList[position])

    }

    override fun getItemCount(): Int {
        return currencyList.size
    }
    fun addCurrency(currency: Currency){
        currencyList.add(currency)
        notifyDataSetChanged()
    }
}