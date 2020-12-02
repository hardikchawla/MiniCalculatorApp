package com.example.calculator

import com.example.calculator.calculator.CalculatorOutputInterfaceView
import com.example.calculator.calculator.CalculatorOutputPresenter
import org.junit.*
import org.mockito.*
import org.mockito.BDDMockito.*

class CalculatorOutputTest {

    private val mmPresenter :CalculatorOutputPresenter = CalculatorOutputPresenter
    private val mmMockView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`() {

        mmPresenter.attach(mmMockView)

        mmPresenter.add("1")
        then(mmMockView).should().setEquation("1")
        mmPresenter.add("+")
        then(mmMockView).should().setEquation("1+")
        mmPresenter.add("1")
        then(mmMockView).should().setEquation("1+1")
        then(mmMockView).should().setOutcome("2")

        mmPresenter.clear()
    }

    @Test
    fun `2 plus 2 minus 1 is 3`() {

        mmPresenter.attach(mmMockView)

        mmPresenter.add("2")
        then(mmMockView).should().setEquation("2")
        mmPresenter.add("+")
        then(mmMockView).should().setEquation("2+")
        mmPresenter.add("2")
        then(mmMockView).should().setEquation("2+2")
        then(mmMockView).should().setOutcome("4")
        mmPresenter.add("-")
        then(mmMockView).should().setEquation("2+2-")
        mmPresenter.add("1")
        then(mmMockView).should().setEquation("2+2-1")
        then(mmMockView).should().setOutcome("3")

        mmPresenter.clear()
    }
}