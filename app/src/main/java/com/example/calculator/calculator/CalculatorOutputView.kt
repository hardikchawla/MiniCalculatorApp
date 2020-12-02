package com.example.calculator.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.calculator.R
import kotlinx.android.synthetic.main.view_calculator_output.view.*

class CalculatorOutputView(context: Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet), CalculatorOutputInterfaceView {

    init {

        orientation = VERTICAL

        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_calculator_output, this, true)
    }

    fun addItem(item: String) {
        CalculatorOutputPresenter.add(item)
    }

    fun removeItem() {
        CalculatorOutputPresenter.remove()
    }

    fun solve() {
        CalculatorOutputPresenter.solve()
    }

    fun clear() {
        CalculatorOutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalculatorOutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CalculatorOutputPresenter.detach()
    }

    override fun setEquation(equation: String) {
        calculator_input_equation.text = equation
    }

    override fun setOutcome(outcome: String) {
        calculator_input_outcome.text = outcome
    }
}